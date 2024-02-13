package com.example.imc_app_mba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtpoids;
    EditText txtTaille;
    EditText txtAge;
    Button btnCalc;
    TextView result;
    ImageFilterView lblresulta;
    RadioButton rdHomme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpoids = (EditText) findViewById(R.id.txtpoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        result = (TextView) findViewById(R.id.result);
        lblresulta = (ImageFilterView) findViewById(R.id.lblresulta);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtpoids.getText().length()>0 && txtTaille.getText().length()>0){
                    float Taille = Float.parseFloat(txtTaille.getText().toString());
                    float Poids = Float.parseFloat(txtpoids.getText().toString());
                    Float imc = CalculIMC(Taille, Poids);

                    if (imc <16){
                        result.setText("votre IMC est:"+imc+"Vous étes trop maigre");
                        lblresulta.setImageResource(R.drawable.maigreur);
                    } else if (imc<18.5){
                        result.setText("votre IMC est:"+imc+"vous étes maigre ");
                        lblresulta.setImageResource(R.drawable.maigreur);
                    } else if (imc <25){
                        result.setText("votre IMC est:"+imc+"vous étes normale ");
                        lblresulta.setImageResource(R.drawable.normale);
                    } else if (imc <30){
                        result.setText("votre IMC est:"+imc+"vous étes Gros(se)");
                        lblresulta.setImageResource(R.drawable.surpoids);
                    } else {
                        result.setText("votre IMC est:"+imc+"vous étes Obèse");
                        lblresulta.setImageResource(R.drawable.obese);

                    }

                }
            }
        });
    }

    Float CalculIMC(float taille, float poids) {
        taille=(taille/100);
        return (float)(poids/(taille*taille));
    }
}