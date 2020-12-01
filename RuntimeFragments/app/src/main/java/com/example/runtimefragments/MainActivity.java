package com.example.runtimefragments;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/*
step6
With the Fragments created and the container added to the layout, we are now
ready to write the code to manipulate the Fragments
 */
public class MainActivity extends AppCompatActivity {

    // declaring the two fragments
    FragmentOne mFragmentOne;
    FragmentTwo mFragmentTwo;
    int showingFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentOne = new FragmentOne();
        mFragmentTwo = new FragmentTwo();
        /*
        set the fragment two to show at the app startup (we can change mFragmentTwo to mFragmentOne to
        show the first fragment at startup
         */
        getFragmentManager().beginTransaction().add(R.id.frameLayout, mFragmentTwo).commit();
        // this will be useful to switch between fragments
        showingFragment = 1;
    }

    // function to switch between fragment used in the switch button
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