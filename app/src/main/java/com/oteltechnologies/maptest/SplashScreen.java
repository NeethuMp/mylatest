package com.oteltechnologies.maptest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView name;
    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent intent = getIntent();
        final String easyPuzzle = intent.getExtras().getString("name");
        name=(TextView)findViewById(R.id.textViewWelcome);
        name.setText("Welcome, "+easyPuzzle);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MyMapActivity.class);
                i.putExtra("name",easyPuzzle);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
