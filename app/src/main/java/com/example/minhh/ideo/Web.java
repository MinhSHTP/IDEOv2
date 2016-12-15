package com.example.minhh.ideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        this.setTitle("Trang web từ vựng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView web = (WebView) findViewById(R.id.webView);
        web.setInitialScale(1);

        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.loadUrl("http://ideo.org.vn/dictionary/#/");
    }
}
