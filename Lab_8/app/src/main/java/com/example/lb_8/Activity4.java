package com.example.lb_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        ImageView icon = findViewById(R.id.myIcon);
        Animation iconAnimation = AnimationUtils.loadAnimation(this, R.anim.myitem_anim);
        icon.startAnimation(iconAnimation);


    }
}