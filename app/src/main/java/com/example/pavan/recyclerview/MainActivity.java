package com.example.pavan.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Holder> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add(new Holder("XYZ", R.drawable.backnew, R.drawable.angular, "AngularJS course"));
        list.add(new Holder("ABC", R.mipmap.ic_launcher, R.drawable.re, "ReactJS course"));
        list.add(new Holder("XYZ", R.mipmap.ic_launcher, R.drawable.node, "NodeJS course"));


        RecyclerView myrv = findViewById(R.id.recyclerview_id);

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, list);

        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);


    }
}
