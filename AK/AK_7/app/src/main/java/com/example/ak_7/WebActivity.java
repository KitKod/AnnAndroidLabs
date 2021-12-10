package com.example.ak_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String site_url = getIntent().getStringExtra("site_url");
        WebView browser = findViewById(R.id.webview);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(site_url);
//        browser.setWebViewClient(new WebViewClient());
    }
}