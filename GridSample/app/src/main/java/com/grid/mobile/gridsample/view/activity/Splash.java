package com.grid.mobile.gridsample.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.grid.mobile.gridsample.R;

public class Splash extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setSplash();
    }
    private void setSplash()
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash.this,HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        },1000);
    }

}
