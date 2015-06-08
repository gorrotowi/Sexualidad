package com.gorro.sexualidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends ActionBarActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "0KOkrxQg64rTlDnMfCq6QhzUElUJ2Ip5SokFqYK4", "U6uMCudRwnsrK5kB0uIHMp4ZGkidNzOrSEfyHRpi");
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                init();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

    }

    private void init() {
        finish();
        startActivity(new Intent(SplashActivity.this, MainSectionsActivity.class));
    }

}
