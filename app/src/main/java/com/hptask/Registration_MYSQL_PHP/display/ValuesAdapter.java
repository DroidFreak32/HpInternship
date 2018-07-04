package com.hptask.Registration_MYSQL_PHP.display;

/**
 * Created by pavan on 17/03/2018.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hptask.Registration_MYSQL_PHP.R;

import java.util.List;


public class ValuesAdapter extends RecyclerView.Adapter<ValuesAdapter.ProductViewHolder> {


    private Context context;
    private List<Value_holder> valueholderList;

    public ValuesAdapter(Context context, List<Value_holder> valueholderList) {
        this.context = context;
        this.valueholderList = valueholderList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Value_holder valueholder = valueholderList.get(position);

        holder.userName.setText(valueholder.getUserName());
        holder.userEmail.setText(valueholder.getUserEmail());
        holder.gender.setText(valueholder.getGender());
    }

    @Override
    public int getItemCount() {
        return valueholderList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userEmail, gender;


        public ProductViewHolder(View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.usernameTextView);
            userEmail = itemView.findViewById(R.id.emailTextView);
            gender = itemView.findViewById(R.id.genderTextView);

        }
    }
}