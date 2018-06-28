package com.example.pavan.listview_fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavan.listview_fragments.R;

/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class ListAdapter extends ArrayAdapter<holder> {
    public ListAdapter(Context context) {
        super(context, R.layout.list_item_design);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item_design, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder h = getItem(position);

        holder.imageView.setImageResource(h.getImage());
        holder.Title.setText(h.getTitle());


        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView Title;


        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image);
            Title = (TextView) view.findViewById(R.id.text_title);

        }
    }
}
