package com.example.lb_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onSecondMenuClick(MenuItem item) {
        Intent intent=new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

    public void onThirdMenuClick(MenuItem item) {
        Intent intent=new Intent(MainActivity.this, Activity3.class);
        startActivity(intent);
    }

    public void onFourthMenuClick(MenuItem item) {
        Intent intent=new Intent(MainActivity.this, Activity4.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView sunImageView = (ImageView)
                findViewById(R.id.sun);
        // Анимация для восхода солнца
        Animation sunRiseAnimation =
                AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        // Подключаем анимацию к нужному View
        sunImageView.startAnimation(sunRiseAnimation);
        // Получим ссылку на часы
        ImageView clockImageView = (ImageView) findViewById(R.id.clock);
// анимация для вращения часов
        Animation clockTurnAnimation =
                AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);
        // получим ссылку на часовую стрелку
        ImageView hourImageView = (ImageView)
                findViewById(R.id.hour_hand);
// анимация для стрелки
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this,
                R.anim.hour_turn);
        // присоединяем анимацию
        hourImageView.startAnimation(hourTurnAnimation);
    }

}