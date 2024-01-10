package com.example.customerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id,name, products, quantity, cost,total,  date;

    public MyAdapter(Context context, ArrayList id,ArrayList name, ArrayList products,ArrayList quantity, ArrayList cost,ArrayList total, ArrayList date) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.products = products;
        this.quantity = quantity;
        this.cost = cost;
        this.total = total;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.alllist,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.products.setText(String.valueOf(products.get(position)));
        holder.quantity.setText(String.valueOf(quantity.get(position)));
        holder.cost.setText(String.valueOf(cost.get(position)));
        holder.total.setText(String.valueOf(total.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,products,quantity,cost,total,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            name = itemView.findViewById(R.id.tName);
            products = itemView.findViewById(R.id.tProducts);
            quantity = itemView.findViewById(R.id.tQuantity);
            cost = itemView.findViewById(R.id.tCost);
            total = itemView.findViewById(R.id.tTotal);
            date = itemView.findViewById(R.id.tDate);
        }
    }

}
