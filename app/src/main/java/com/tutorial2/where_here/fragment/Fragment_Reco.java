package com.tutorial2.where_here.fragment;


import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tutorial2.where_here.R;


public class Fragment_Reco extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_reco, container, false);
    }

    Integer[] images = {
            R.drawable.ic_launcher_foreground
    };


}