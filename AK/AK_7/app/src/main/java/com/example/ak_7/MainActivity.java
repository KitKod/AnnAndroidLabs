package com.example.ak_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private ArrayList<Integer> selectedItems;
    private ArrayList<String> selectedItems;
    private List<String> site_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedItems = new ArrayList<String>();
        // Get reference of widgets from XML layout
        final ListView ListView = (android.widget.ListView) findViewById(R.id.ListViewID);
        final Button AddItem = (Button) findViewById(R.id.AddItemBtn);
        final Button RemoveButton = (Button) findViewById(R.id.remove_button);
        final Button GoButton = (Button) findViewById(R.id.go_button);
        final EditText AddSiteEdit = (EditText) findViewById(R.id.edit_site);

        // Initializing a new String Array
        String[] sites = new String[] {
                "https://www.youtube.com/",
                "https://www.google.com/"
        };

        // Create a List from String Array elements
        site_list = new ArrayList<String>(Arrays.asList(sites));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, site_list);

        // DataBind ListView with items from ArrayAdapter
        ListView.setAdapter(arrayAdapter);


        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray clickedItemPositions = ListView.getCheckedItemPositions();

                for(int index = 0; index < clickedItemPositions.size(); index++){
                    boolean checked = clickedItemPositions.valueAt(index);

                    if(checked){
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) ListView.getItemAtPosition(key);
                        selectedItems.add(item);
                    }
                }
            }
        });

        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_site = AddSiteEdit.getText().toString();

                if (new_site.equals("")) {
                    return;
                }

                site_list.add(new_site);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String item: selectedItems) {
                    site_list.remove(item);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });

        GoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItems.size() != 0) {
                    String site_url = selectedItems.get(selectedItems.size() - 1);

                    Intent myIntent = new Intent(v.getContext(), WebActivity.class);
                    myIntent.putExtra("site_url", site_url);
                    startActivity(myIntent);
                }
            }
        });
    }
}