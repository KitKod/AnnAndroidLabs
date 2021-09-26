package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickOnShowMsg(view: View) {
        var helloTextView = findViewById<TextView>(R.id.Msg_textView)
        helloTextView.visibility = if (helloTextView.visibility == View.VISIBLE){
            View.INVISIBLE
        } else{
            View.VISIBLE
        }

    }
}