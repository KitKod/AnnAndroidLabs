package com.example.ak_56;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("my", "Зинчука Анна");
        startActivity(intent);
    }
  /* public void OnClick(View view) {

    }*/
}
