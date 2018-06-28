package com.example.pavan.listview_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pavan.listview_fragments.R;

/* Fragment used as page 3 */
public class fragment_three extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three, container, false);

        ListView lvCards = rootView.findViewById(R.id.list_cards);
        ListAdapter adapter = new ListAdapter(getActivity());

        lvCards.setAdapter(adapter);
        adapter.addAll(new holder("Pavan", R.drawable.w),
                new holder("Denzil", R.drawable.w),
        new holder("Kiran", R.drawable.w),
        new holder("Rashad", R.drawable.w),
        new holder("Anil", R.drawable.w),
        new holder("Deepak", R.drawable.w),
        new holder("Rashad", R.drawable.w),
        new holder("Anil", R.drawable.w),
        new holder("Deepak", R.drawable.w));

        return rootView;
    }
}


