package com.example.fragmentbackstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonNext = findViewById(R.id.buttonNext);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentTwo())
                        .addToBackStack(null).commit();
                mButtonNext.setVisibility(View.INVISIBLE);
            }
        });
        getFragmentManager().beginTransaction().add(R.id.frameLayout, new FragmentOne())
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 2) {
            super.onBackPressed();
            mButtonNext.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }
}