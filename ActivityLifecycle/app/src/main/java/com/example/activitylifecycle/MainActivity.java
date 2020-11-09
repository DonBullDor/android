package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TextView)findViewById(R.id.textViewState)).setText("onCreate()n");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.textViewState)).append("onStart()\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((TextView) findViewById(R.id.textViewState)).append("onResume()\n")
        ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((TextView) findViewById(R.id.textViewState)).append("onPause()\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ((TextView) findViewById(R.id.textViewState)).append("onStop()\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ((TextView) findViewById(R.id.textViewState)).append("onRestart()\n"
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((TextView) findViewById(R.id.textViewState)).append("onDestroy()\n"
        );
    }
}