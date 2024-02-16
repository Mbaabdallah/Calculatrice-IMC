package com.example.imc_app_mba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class welcome extends AppCompatActivity {
    Button cnxx;
    Button about;
    TextInputEditText username;
    TextInputEditText userpwd;
    TextView infoo;
    int counter=5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        cnxx = findViewById(R.id.cnx);
        username = findViewById(R.id.nom);
        userpwd = findViewById(R.id.pwd);
        about = findViewById(R.id.about);
        infoo = findViewById(R.id.infoo);

        infoo.setText("nombre de tentatives restantes: 5");




        cnxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), userpwd.getText().toString());




            }
        });
    }
    void validate(String username, String userpwd){
        if ((username.equals("MBA")) && ( userpwd.equals("123"))){
            Intent intent= new Intent(welcome.this, MainActivity.class);
            startActivity(intent);

        }else {
            counter--;

            infoo.setText("nombre de tentatives restantes"+ String.valueOf(counter));
            if (counter==0){
                cnxx.setEnabled(false);
            }
        }
    }
}