package com.example.activitystarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set activity_main.xml the default at the application start
        setContentView(R.layout.activity_main);
    }

    public void launchIntent(View view) {
        // we created an intent object with the ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //  the intention is to view the website
        intent.setData(Uri.parse("https://www.google.com/"));
        // we just want to open a browser with the specified URL, so we call the startActivity() method
        startActivity(intent);
    }

    public void onClickSwitchActivity(View view) {
        // get the editText from xml
        EditText editText = findViewById(R.id.editTextData);
        // get the text form the editText and put it in variable text
        String text = editText.getText().toString();
        // declare the second activity for the Intent using SecondActivity.class
        Intent intent = new Intent(this, SecondActivity.class);
        // put the text we got from the edit text to pass it to the second activity
        intent.putExtra(Intent.EXTRA_TEXT,text);
        // start the second activity
        startActivity(intent);
    }
}