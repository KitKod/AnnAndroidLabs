package com.example.lb_5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputSumText;
    private RadioButton radioButtonSourseCurrencyH;
    private RadioButton radioButtonSourseCurrencyD;
    private RadioButton radioButtonSourseCurrencyE;
    private RadioButton radioButtonResultCurrencyH;
    private RadioButton radioButtonResultCurrencyD;
    private RadioButton radioButtonResultCurrencyE;
    private TextView textViewRes;
    private static final int REQUEST_ACCESS_TYPE=1;
    static final String ACCESS_MESSAGE="ACCESS_MESSAGE";
    static final String RATE_HRN_TO_DOL="RATE_HRN_TO_DOL";
    static final String RATE_DOL_TO_HRN="RATE_DOL_TO_HRN";
    static final String RATE_EUR_TO_DOL="RATE_EUR_TO_DOL";
    static final String RATE_DOL_TO_EUR="RATE_DOL_TO_EUR";
    static final String RATE_HRN_TO_EUR="RATE_HRN_TO_EUR";
    static final String RATE_EUR_TO_HRN="RATE_EUR_TO_HRN";

    //Объявляем и инициализируем переменные для хранения курсов валют
    private String rateHrnToDol="26.4";
    private String rateDolToHrn="26.2";
    private String rateEurToDol="1.16";
    private String rateDolToEur="0.9";
    private String rateHrnToEur="30.6";
    private String rateEurToHrn="30.2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Подключаем элементы с activity_main.xml
        inputSumText=(EditText)findViewById(R.id.editTextSource);
        radioButtonSourseCurrencyH=(RadioButton)findViewById
                (R.id.radioButtonSourseCurrencyHrn);
        radioButtonSourseCurrencyD=(RadioButton)findViewById
                (R.id.radioButtonSourseCurrencyDol);
        radioButtonSourseCurrencyE=(RadioButton)findViewById
                (R.id.radioButtonSourseCurrencyEur);
        radioButtonResultCurrencyH=(RadioButton)findViewById
                (R.id.radioButtonResultCurrencyHrn);
        radioButtonResultCurrencyD=(RadioButton)findViewById
                (R.id.radioButtonResultCurrencyDol);
        radioButtonResultCurrencyE=(RadioButton)findViewById
                (R.id.radioButtonResultCurrencyEur);
        textViewRes=(TextView)findViewById(R.id.textViewSum);
    }
    //стартуем CheckRateActivity и передаем туда курсы валют
    public void onCheckChangeRate(View view) {
        Intent intent=new Intent(MainActivity.this,
                CheckRateActivity.class);
        intent.putExtra(RATE_HRN_TO_DOL,rateHrnToDol);
        intent.putExtra(RATE_DOL_TO_HRN,rateDolToHrn);
        intent.putExtra(RATE_EUR_TO_DOL,rateEurToDol);
        intent.putExtra(RATE_DOL_TO_EUR,rateDolToEur);
        intent.putExtra(RATE_HRN_TO_EUR,rateHrnToEur);
        intent.putExtra(RATE_EUR_TO_HRN,rateEurToHrn);
        startActivityForResult(intent,REQUEST_ACCESS_TYPE);
    }
    //возвращаем измененные курсы валют из CheckRateActivity
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data){
        if(requestCode==REQUEST_ACCESS_TYPE){
            if(resultCode==RESULT_OK){
                //String accessMessage =
                data.getStringExtra(ACCESS_MESSAGE);
                rateHrnToDol=data.getStringExtra(RATE_HRN_TO_DOL);
                rateDolToHrn=data.getStringExtra(RATE_DOL_TO_HRN);
                rateEurToDol=data.getStringExtra(RATE_EUR_TO_DOL);
                rateDolToEur=data.getStringExtra(RATE_DOL_TO_EUR);
                rateHrnToEur=data.getStringExtra(RATE_HRN_TO_EUR);
                rateEurToHrn=data.getStringExtra(RATE_EUR_TO_HRN);
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    //Пересчет по курсу
    public void onExchange(View view) {
        float inputSum;
        if (inputSumText.getText().toString().equals("")) {
            textViewRes.setText("Укажите сумму");
            return;
        } else {
            inputSum = Float.parseFloat(inputSumText.getText().toString());
        }
        if ((radioButtonSourseCurrencyH.isChecked()) &&
                (radioButtonResultCurrencyH.isChecked())) {
            textViewRes.setText("Не нужно саму в себя");}
        if ((radioButtonSourseCurrencyH.isChecked()) &&
                (radioButtonResultCurrencyD.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum /
                    Float.parseFloat(rateHrnToDol))));}
        if ((radioButtonSourseCurrencyD.isChecked()) &&
                (radioButtonResultCurrencyH.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum *
                    Float.parseFloat(rateDolToHrn))));}
        if ((radioButtonSourseCurrencyE.isChecked()) &&
                (radioButtonResultCurrencyE.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum /
                    Float.parseFloat(rateEurToDol))));}

        if ((radioButtonResultCurrencyH.isChecked()) &&
                (radioButtonResultCurrencyH.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum *
                    Float.parseFloat(rateDolToEur))));}
        if ((radioButtonResultCurrencyH.isChecked()) &&
                (radioButtonResultCurrencyD.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum /
                    Float.parseFloat(rateHrnToEur))));}
        if ((radioButtonResultCurrencyE.isChecked()) &&
                (radioButtonResultCurrencyH.isChecked())) {
            textViewRes.setText(String.valueOf(onRound(inputSum *
                    Float.parseFloat(rateEurToHrn))));}
    }
    public float onRound(float number){
        return (float) Math.round(number*100)/100;}
}