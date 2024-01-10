package com.example.customerlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editProduct, editQuantity,editCost,editDate;
    TextView btnSave , btnTotal , editTotal ;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        builder = new AlertDialog.Builder(this);
        editName = (EditText)findViewById(R.id.eName);
        editProduct = (EditText)findViewById(R.id.eProducts);
        editQuantity = (EditText)findViewById(R.id.eQuantity);
        editCost = (EditText)findViewById(R.id.eCost);
        editDate = (EditText)findViewById(R.id.edate);
        editTotal = (TextView)findViewById(R.id.eTotal);
        btnSave = (TextView) findViewById(R.id.btnSaved);
        btnTotal = (TextView)findViewById(R.id.btnTotal);
        AddData();

        btnTotal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { openTotal(); }
        });

    }

    public void AddData(){
        btnSave = (TextView) findViewById(R.id.btnSaved);
        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String txtName = editName.getText().toString();
                String txtProduct = editProduct.getText().toString();
                String txtQuantity = editQuantity.getText().toString();
                String txtCost = editCost.getText().toString();
                String txtTotal = editTotal.getText().toString();
                String txtDate = editDate.getText().toString();

                if(txtProduct == " " || txtCost == " " || txtDate == " "){
                    builder.setTitle("Alert!!")
                            .setMessage("Kindly provide your credentials for authentication. Your cooperation is greatly appreciated.")
                            .setCancelable(true)
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int z) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
                else {
                    boolean isInserted = myDb.insertData(txtName,txtProduct,txtQuantity, txtCost,txtTotal, txtDate);
                    if (isInserted = true) {
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        editProduct.setText(" ");
                        editCost.setText(" ");
                        editName.setText(" ");
                        editDate.setText(" ");
                        editTotal.setText(" ");
                        editQuantity.setText(" ");

                    } else {
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public void openTotal(){

        String quantity = editQuantity.getText().toString();
        String cost = editCost.getText().toString();
        int num1 = Integer.parseInt(quantity);
        int num2 = Integer.parseInt(cost);
        int total = num1 * num2;
        editTotal.setText(String.valueOf(total));
    }

}