package com.example.lab_2_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_close) {
            info.setText("Вы выбрали Закрыть");
            onCloseMenuClick();
        } else if (id == R.id.action_setting) {
            info.setText("Вы выбрали Настройки");
            onSettingMenuClick();
        } else if (id == R.id.action_help) {
            info.setText("Вы выбрали Справку");
            onAboutMenuClick();
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void onCloseMenuClick() {
        this.finish();
        System.exit(0);
    }

    public void onSettingMenuClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Внимание!");
        builder.setMessage("Вы действительно хотите выйти?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onCloseMenuClick();
            }
        });
        builder.setNegativeButton("Нет", null);
        builder.show();
    }

    public void onAboutMenuClick() {
        Intent intent=new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}