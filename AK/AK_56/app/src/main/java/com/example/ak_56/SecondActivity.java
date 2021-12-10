package com.example.ak_56;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        if (arguments!=null) {
            String mes = arguments.get("my").toString();
            textView.setText("Сообщение: " + mes);
        }
        setContentView(textView);
    }
}
