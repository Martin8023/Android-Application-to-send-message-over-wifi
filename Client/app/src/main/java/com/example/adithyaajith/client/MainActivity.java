package com.example.adithyaajith.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar warn1Bar;
    ProgressBar warn2Bar;
    ProgressBar warn3Bar;
    ProgressBar warn4Bar;
    ProgressBar warn5Bar;
    ProgressBar warn6Bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warn1Bar = (ProgressBar) findViewById(R.id.progressBar);
        warn2Bar = (ProgressBar) findViewById(R.id.progressBar);
        warn3Bar = (ProgressBar) findViewById(R.id.progressBar);
        warn4Bar = (ProgressBar) findViewById(R.id.progressBar);
        warn5Bar = (ProgressBar) findViewById(R.id.progressBar);
        warn6Bar = (ProgressBar) findViewById(R.id.progressBar);


        warn1Bar.setVisibility(View.VISIBLE);
        warn1Bar.setVisibility(View.INVISIBLE);


    }
}
