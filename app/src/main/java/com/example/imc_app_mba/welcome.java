package com.example.imc_app_mba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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



        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/in/montassar-bellah-abdallah-444931168/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });
        cnxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChampsRemplis()) {
                    validate(username.getText().toString(), userpwd.getText().toString());
                } else {
                    Toast.makeText(welcome.this, "Remplissez les champs s'il vous plaît", Toast.LENGTH_SHORT).show();
                    infoo.setText("nombre de tentatives restantes: 5");
                }


            }
            boolean isChampsRemplis() {
                return username.getText().length() > 0 && userpwd.getText().length() > 0;
            }
        });
    }
    void validate(String username, String userpwd){
        if ((username.equals("MBA")) && ( userpwd.equals("123"))){
            Intent intent= new Intent(welcome.this, MainActivity.class);
            startActivity(intent);

        }else {
            counter--;

            infoo.setText("nombre de tentatives restantes: "+ String.valueOf(counter));
            if (counter==0){
                cnxx.setEnabled(false);
            }
        }
    }

}