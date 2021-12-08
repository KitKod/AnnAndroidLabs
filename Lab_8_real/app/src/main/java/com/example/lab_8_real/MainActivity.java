package com.example.lab_8_real;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERECES="mySettings";
    public static final String APP_PREFERECES_COUNTER="counter";
    private SharedPreferences settings;

    //для текстового редактора
    private final static String FILENAME="file.txt";//имя файла
    private EditText file_text;

    private TextView text_counter;
    private int counter = 0;
    private Button button_minus;
    private Button button_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(APP_PREFERECES, Context.MODE_PRIVATE);

        text_counter = findViewById(R.id.text_counter);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);

        file_text = findViewById(R.id.file);


        button_minus.setOnClickListener(onButtonsClick());
        button_plus.setOnClickListener(onButtonsClick());
    }

    @Override
    protected void onPause() {
        counter = Integer.parseInt(text_counter.getText().toString());
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(APP_PREFERECES_COUNTER, counter);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (settings.contains(APP_PREFERECES_COUNTER)) {
            // Получаем число из настроек
            counter = settings.getInt(APP_PREFERECES_COUNTER, 0);
            // Выводим на экран данные из настроек
            text_counter.setText(String.valueOf(counter));
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // читаем установленное значение из CheckBoxPreference
        if (prefs.getBoolean(getString(R.string.pref_openmode),false)) {
            openFile(FILENAME);
        }

        // читаем размер шрифта из EditTextPreference
        float fSize = Float.parseFloat(prefs.getString(getString(R.string.pref_size), "20"));
        // применяем настройки в текстовом поле
        file_text.setTextSize(fSize);

        // читаем стили текста из ListPreference
        String regular = prefs.getString(getString(R.string.pref_style), "");
        int typeface = Typeface.NORMAL;

        if (regular.contains("Полужирный")) {
            typeface += Typeface.BOLD;
        }
        if (regular.contains("Курсив")) {
            typeface += Typeface.ITALIC;
        }
        // меняем настройки в EditText
        file_text.setTypeface(null, typeface);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_open) {
            openFile(FILENAME);
            return true;
        } else if (id == R.id.action_save) {
            saveFile(FILENAME);
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return true;
        }
    }

    // Метод для открытия файла
    private void openFile(String fileName) {
        try {
            InputStream inputStream = openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                inputStream.close();
                file_text.setText(builder.toString());
                Toast.makeText(this, "Файл считан", Toast.LENGTH_LONG).show();
            }
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),"Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    // Метод для сохранения файла
    private void saveFile(String fileName) {
        try {
            OutputStream outputStream = openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(file_text.getText().toString());
            osw.close();
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_LONG).show();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),"Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private View.OnClickListener onButtonsClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();

                if (id == R.id.button_plus) {
                    counter++;
                    text_counter.setText(String.valueOf(counter));
                } else if (id == R.id.button_minus) {
                    counter--;
                    text_counter.setText(String.valueOf(counter));
                }
            }
        };
    }
}