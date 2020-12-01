package com.example.createfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/*
Fragments are a way to separate your UI into smaller
sections that can easily be reused. Think of Fragments as mini-activities, complete with
their own classes, layouts, and life cycle. Instead of designing your screen in one Activity
Layout, possibly duplicating functionality across multiple layouts, you can break the screen
into smaller, logical sections and turn them into Fragments. Your Activity Layout can then
reference one or multiple Fragments, as needed.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}