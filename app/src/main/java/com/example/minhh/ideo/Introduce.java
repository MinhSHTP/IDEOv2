package com.example.minhh.ideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Introduce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        this.setTitle("Sơ lược về ứng dụng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView web = (WebView) findViewById(R.id.webView);
        web.setInitialScale(1);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.loadUrl("file:///android_asset/introduce/introduce");
    }
}
