package com.example.fragmentcommunication;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class DetailFragment extends Fragment {

    public static String KEY_COUNTRY_NAME = "KEY_COUNTRY_NAME";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null && bundle.containsKey(KEY_COUNTRY_NAME)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                showSelectedCountry(bundle.getString(KEY_COUNTRY_NAME));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void showSelectedCountry(String countryName) {
        ((TextView) Objects.requireNonNull(getView()).findViewById(R.id.textViewCountryName)).setText(countryName);
    }
}