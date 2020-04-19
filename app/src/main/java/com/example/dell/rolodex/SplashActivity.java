package com.example.dell.rolodex;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loadmainactivity = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(loadmainactivity);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_in);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
