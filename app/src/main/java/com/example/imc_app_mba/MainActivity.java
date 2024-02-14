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
    Button btnCalc;
    TextView result;
    ImageFilterView lblresulta;
    RadioButton rdFemme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpoids = findViewById(R.id.txtpoids);
        txtTaille = findViewById(R.id.txtTaille);
        btnCalc = findViewById(R.id.btnCalc);
        result = findViewById(R.id.result);
        lblresulta = findViewById(R.id.lblresulta);
        rdFemme = findViewById(R.id.rdFemme);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtpoids.getText().length() > 0 && txtTaille.getText().length() > 0) {
                    float Taille = Float.parseFloat(txtTaille.getText().toString());
                    float Poids = Float.parseFloat(txtpoids.getText().toString());
                    Float imc = CalculIMC(Taille, Poids);

                    // Obtenez la valeur de la balise (tag) du bouton radio sélectionné
                    int selectedSexe = rdFemme.isChecked() ? 0 : 1; // 0 pour Femme, 1 pour Homme


                    if (selectedSexe == 0) { // Femme
                        if (imc < 16) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes trop maigre");
                            lblresulta.setImageResource(R.drawable.maigreurf);
                        } else if (imc < 18.5) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes maigre");
                            lblresulta.setImageResource(R.drawable.maigreurf);
                        } else if (imc < 25) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes normale");
                            lblresulta.setImageResource(R.drawable.normalef);
                        } else if (imc < 30) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes Grosse");
                            lblresulta.setImageResource(R.drawable.surpoidsf);
                        } else {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes Obèse");
                            lblresulta.setImageResource(R.drawable.obesef);
                        }
                    } else { // Homme
                        if (imc < 16) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes trop maigre");
                            lblresulta.setImageResource(R.drawable.maigreur);
                        } else if (imc < 18.5) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes maigre");
                            lblresulta.setImageResource(R.drawable.maigreur);
                        } else if (imc < 25) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes normale");
                            lblresulta.setImageResource(R.drawable.normale);
                        } else if (imc < 30) {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes Gros");
                            lblresulta.setImageResource(R.drawable.surpoids);
                        } else {
                            result.setText("Votre IMC est:" + imc + " \n Vous êtes Obèse");
                            lblresulta.setImageResource(R.drawable.obese);
                        }
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