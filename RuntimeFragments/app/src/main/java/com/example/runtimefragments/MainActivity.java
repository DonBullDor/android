package com.example.runtimefragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentOne mFragmentOne;
    FragmentTwo mFragmentTwo;
    int showingFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentOne = new FragmentOne();
        mFragmentTwo = new FragmentTwo();
        getFragmentManager().beginTransaction().add(R.id.frameLayout, mFragmentOne).commit();
        showingFragment = 1;
    }

    public void switchFragment(View view) {
        if (showingFragment == 1) {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout, mFragmentTwo).commit();
            showingFragment = 2;
        } else {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout, mFragmentOne).commit();
            showingFragment = 1;
        }
    }
}