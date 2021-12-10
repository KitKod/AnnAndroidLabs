package com.example.ak_8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnimationActivity2 extends AppCompatActivity {
private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);
        String duration = "0";
        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.textView);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            duration = new String(bytes);

        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fin!=null) fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        textView.setText(duration);
        ImageView img = findViewById(R.id.animationView);
        // устанавливаем ресурс анимации
        if (Integer.parseInt(duration) == 100) {
            textView.setText(duration);
            img.setBackgroundResource(R.drawable.man_animation_1);
        }
        else if (Integer.parseInt(duration) == 200) {
            textView.setText(duration);
            img.setBackgroundResource(R.drawable.man_animation_2);
        }
        else {
            textView.setText(duration);
            img.setBackgroundResource(R.drawable.man_animation_3);
        }
        // получаем объект анимации
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // по нажатию на ImageView
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // запускаем анимацию
                frameAnimation.start();
            }
        });
    }
}