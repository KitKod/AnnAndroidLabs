package com.example.lab_2_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button orientationBtn;
    private int count = 0;
    private static final String KEY_COUNT = "COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        orientationBtn = findViewById(R.id.button7);
        orientationBtn.setOnClickListener(initOrientationBtnAction());

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            textView.setText(count + " " + getRotateOrientatin());
        }

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //для альбомного режима
        //или
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //для портретного режима

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }

    private String getScreenOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return "Портретная ориентация";
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return "Альбомная ориентация";
        } else {
            return "";
        }
    }

    private String getRotateOrientatin() {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "Не поворачивали";
            case Surface.ROTATION_90:
                return "Повернули против часовой";
            case Surface.ROTATION_180:
                return "Повернули на 180 градусов";
            case Surface.ROTATION_270:
                return "Повернули по часовой";
            default:
                return "Не понятно";
        }
    }

    private View.OnClickListener initOrientationBtnAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(++count + " " + getRotateOrientatin());
            }
        };
    }

}