package com.example.lb_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawMyIcon drawsecond = new DrawMyIcon(this);
        setContentView(drawsecond);
    }
}