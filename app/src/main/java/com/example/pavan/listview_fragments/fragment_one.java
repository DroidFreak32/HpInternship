package com.example.pavan.listview_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pavan.listview_fragments.R;


public class fragment_one extends Fragment {




View v;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       //eturn super.onCreateView(inflater, container, savedInstanceState);
       v= inflater.inflate(R.layout.fragment_one, container, false);


       return v;
    }
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        btn=rootView.findViewById(R.id.button);


        return rootView;
    }*/
}




