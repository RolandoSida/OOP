package com.example.customerlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private TextView Tlogin;
    EditText euser,epass;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        builder = new AlertDialog.Builder(this);
        euser = (EditText)findViewById(R.id.Euser);
        epass = (EditText)findViewById(R.id.Epass);
        Tlogin = (TextView) findViewById(R.id.Tlogin);
        Tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openDashboard(); }
        });

    }

    public void openDashboard (){

        String txtuser = euser.getText().toString();
        String txtpass = epass.getText().toString();
        String user = "account";
        String pass = "secret";


        if(user.equals(txtuser) && pass.equals(txtpass)) {
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);

        }else {
            builder.setTitle("Wrong Credentials!!")
                    .setMessage("Wrong Username & Password")
                    .setCancelable(true)
                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int z) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }

    }

}