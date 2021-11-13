package com.example.lab_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textView;
    private Button redBtn;
    private Button yellowBtn;
    private Button greenBtn;
    private Button aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.activity_main);
        textView = findViewById(R.id.textViewColor);

        redBtn = findViewById(R.id.buttonRed);
        yellowBtn = findViewById(R.id.buttonYellow);
        greenBtn = findViewById(R.id.buttonGreen);
        aboutBtn = findViewById(R.id.buttonAbout);

        redBtn.setOnClickListener(onButtonsClick());
        yellowBtn.setOnClickListener(onButtonsClick());
        greenBtn.setOnClickListener(onButtonsClick());
        aboutBtn.setOnClickListener(onButtonsClick());
    }

    private View.OnClickListener onButtonsClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();

                if (id == R.id.buttonRed) {
                    textView.setText(R.string.red);
                    relativeLayout.setBackgroundResource(R.color.colorRed);
                } else if (id == R.id.buttonYellow) {
                    textView.setText(R.string.yellow);
                    relativeLayout.setBackgroundResource(R.color.colorYellow);
                } else if (id == R.id.buttonGreen) {
                    textView.setText(R.string.green);
                    relativeLayout.setBackgroundResource(R.color.colorGreen);
                } else if (id == R.id.buttonAbout) {
                    Intent intent= new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                }

            }
        };
    }
}