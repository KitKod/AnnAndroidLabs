package com.example.lb_5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CheckRateActivity extends AppCompatActivity {
    private EditText eTextHrnToDol;
    private EditText eTextDolToHrn;
    private EditText eTextEurToDol;
    private EditText eTextDolToEur;
    private EditText eTextHrnToEur;
    private EditText eTextEurToHrn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_rate);
        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            eTextHrnToDol=(EditText)findViewById(R.id.editTextHrnToDol);
            eTextDolToHrn=(EditText)findViewById(R.id.editTextDolToHrn);
            eTextEurToDol=(EditText)findViewById(R.id.editTextEurToDol);
            eTextDolToEur=(EditText)findViewById(R.id.editTextDolToEur);
            eTextHrnToEur=(EditText)findViewById(R.id.editTextHrnToEur);
            eTextEurToHrn=(EditText)findViewById(R.id.editTextEurToHrn);
            //получаем курсы валют из MainActivity
            eTextHrnToDol.setText(extras.getString(MainActivity.RATE_HRN_TO_DOL));
            eTextDolToHrn.setText(extras.getString(MainActivity.RATE_DOL_TO_HRN));
            eTextEurToDol.setText(extras.getString(MainActivity.RATE_EUR_TO_DOL));
            eTextDolToEur.setText(extras.getString(MainActivity.RATE_DOL_TO_EUR));
            eTextHrnToEur.setText(extras.getString(MainActivity.RATE_HRN_TO_EUR));
            eTextEurToHrn.setText(extras.getString(MainActivity.RATE_EUR_TO_HRN));
        }
    }
    //возвращаем измененные курсы валют в MainActivity
    public void onBack(View view) {
        Intent data = new Intent();

        data.putExtra(MainActivity.RATE_HRN_TO_DOL,eTextHrnToDol.getText().toString());

        data.putExtra(MainActivity.RATE_DOL_TO_HRN,eTextDolToHrn.getText().toString());

        data.putExtra(MainActivity.RATE_EUR_TO_DOL,eTextEurToDol.getText().toString());

        data.putExtra(MainActivity.RATE_DOL_TO_EUR,eTextDolToEur.getText().toString());

        data.putExtra(MainActivity.RATE_HRN_TO_EUR,eTextHrnToEur.getText().toString());

        data.putExtra(MainActivity.RATE_EUR_TO_HRN,eTextEurToHrn.getText().toString());
        setResult(RESULT_OK,data);
        finish();
    }
}