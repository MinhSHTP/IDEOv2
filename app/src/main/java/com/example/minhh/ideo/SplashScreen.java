package com.example.minhh.ideo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    int TIME_OUT = 2;
    ImageView _SplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        _SplashScreen = (ImageView) findViewById(R.id.imgSplashScreen);
        _SplashScreen.setImageResource(R.drawable.splashscreen);
        _SplashScreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                _SplashScreen.setImageResource(R.drawable.splash_screen_fix);
            }
        }, TIME_OUT * 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, Home.class);
                startActivity(home);
                finish();
            }
        }, TIME_OUT * 1900);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
