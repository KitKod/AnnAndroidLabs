package com.example.ak_34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int clicks = 0;
    private TextView text;
    private Button minus_b;
    private Button plus_b;
    private View plus_b_v;
    private View minus_b_v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        minus_b_v = findViewById(R.id.minus_button);
        plus_b_v = findViewById(R.id.plus_button);

        minus_b = minus_b_v.findViewById(R.id.clicksBt);
        plus_b = plus_b_v.findViewById(R.id.clicksBt);
        text = findViewById(R.id.clicksText);

        minus_b.setText("-");
        plus_b.setText("+");

        minus_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks--;
                text.setText(clicks + " Clicks");
            }
        });

        plus_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                text.setText(clicks + " Clicks");
            }
        });

    }
}