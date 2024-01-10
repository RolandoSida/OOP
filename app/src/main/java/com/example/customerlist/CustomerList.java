package com.example.customerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, name, products,quantity, cost,total, date;
    DatabaseHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        products = new ArrayList<>();
        quantity = new ArrayList<>();
        cost = new ArrayList<>();
        total = new ArrayList<>();
        date = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,name,products,quantity,cost,total,date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(CustomerList.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                products.add(cursor.getString(2));
                quantity.add(cursor.getString(3));
                cost.add(cursor.getString(4));
                total.add(cursor.getString(5));
                date.add(cursor.getString(6));
            }
        }
    }

}