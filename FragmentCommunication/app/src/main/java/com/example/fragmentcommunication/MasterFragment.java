package com.example.fragmentcommunication;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.ListFragment;

import java.util.Objects;

public class MasterFragment extends ListFragment {
    public interface OnMasterSelectedListener {
        void onItemSelected(String countryName);
    }

    private OnMasterSelectedListener mOnMasterSelectedListener = null;

    public void setOnMasterSelectedListener(OnMasterSelectedListener listener) {
        mOnMasterSelectedListener = listener;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] countries = new String[]{"China", "France",
                "Germany", "India", "Russia", "United Kingdom",
                "United States"};

        ListAdapter countryAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1,
                countries);
        setListAdapter(countryAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View
                    view, int position, long id) {
                if (mOnMasterSelectedListener != null) {
                    mOnMasterSelectedListener.onItemSelected(((
                            TextView) view).getText().toString());
                }
            }
        });
    }
}
