package com.example.pavan.listview_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pavan.listview_fragments.R;

import java.util.ArrayList;
import java.util.List;

/* Fragment used as page 2 */
public class fragment_two extends Fragment {
    List<holder> list ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        list = new ArrayList<>();

        list.add(new holder("ReactJs",R.drawable.re));
        list.add(new holder("Node.js",R.drawable.node));
        list.add(new holder("AngularJS",R.drawable.angular));
        list.add(new holder("ReactJs",R.drawable.re));
        list.add(new holder("Node.js",R.drawable.node));
        list.add(new holder("AngularJS",R.drawable.angular));
        list.add(new holder("ReactJs",R.drawable.re));
        list.add(new holder("Node.js",R.drawable.node));
        list.add(new holder("AngularJS",R.drawable.angular));


        RecyclerView myrv = rootView.findViewById(R.id.recyclerview_id);

      RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),list);

        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));

        myrv.setAdapter(myAdapter);
        return rootView;
    }


}
