package com.example.androidversion;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startLoading();
    }
    private void startLoading() {
        Handler Splash_handler = new Handler();
        Splash_handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000); //1.5초간
    }
}
