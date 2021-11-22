package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView helloTextView;
    private ImageButton changeTextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTextBtn = findViewById(R.id.imageButton);
        changeTextBtn.setOnClickListener(getCliclListener());

        helloTextView = findViewById(R.id.textView2);
    }

    private View.OnClickListener getCliclListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloTextView.setText("Hello Friend!!!");
            }
        };
    }

}