package com.example.ak_8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButtonDuration1;
    private RadioButton radioButtonDuration2;
    private RadioButton radioButtonDuration3;
    private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonDuration1=(RadioButton)findViewById
                (R.id.radioButtonDuration1);
        radioButtonDuration2=(RadioButton)findViewById
                (R.id.radioButtonDuration2);
        radioButtonDuration3=(RadioButton)findViewById
                (R.id.radioButtonDuration3);
    }

    public void Click(View view) {
        String duration = "0";
        FileOutputStream fos = null;
        if (radioButtonDuration1.isChecked()){
            duration = "100";
        }
        if (radioButtonDuration2.isChecked()){
            duration = "200";
        }
        if (radioButtonDuration3.isChecked()){
            duration = "300";
        }
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(duration.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{ if(fos!=null) fos.close();}
            catch(IOException ex){}
        }
        Intent intent=new Intent(MainActivity.this, AnimationActivity2.class);
        startActivityForResult(intent,1);
    }
}