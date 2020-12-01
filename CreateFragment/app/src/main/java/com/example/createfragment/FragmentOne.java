package com.example.createfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
second step:
Create a new Java class called FragmentOne.java with the following code:
 */
public class FragmentOne extends Fragment {
    // create the fragment and attach it to the fragment section in activity_main.xml
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container,
                false);
    }
}
