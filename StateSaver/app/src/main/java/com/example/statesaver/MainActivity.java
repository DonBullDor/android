package com.example.statesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        int defaultCounter = 0;
        mCounter = settings.getInt(KEY_COUNTER, defaultCounter);
        ((TextView) findViewById(R.id.textViewCounter))
                .setText(String.format("Counter: %s", mCounter));
    }

    static final String KEY_COUNTER = "COUNTER";
    private int mCounter = 0;

    public void onClickCounter(View view) {
        mCounter++;
        ((TextView) findViewById(R.id.textViewCounter))
                .setText(String.format("Counter: %s", mCounter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt(KEY_COUNTER);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(KEY_COUNTER, mCounter);
        editor.apply();
    }
}