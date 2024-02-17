package com.example.imc_app_mba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtpoids;
    EditText txtTaille;
    Button btnCalc;
    TextView result;
    ImageFilterView lblresulta;
    RadioButton rdFemme;
    ImageButton infoButton;


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
        infoButton = findViewById(R.id.infoBull);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Developed by Montassar bellah ABDALLAH");
            }
        });


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                // Vérifiez si les champs de taille et poids sont remplis
                if (isChampsRemplis()) {
                if (txtpoids.getText().length() > 0 && txtTaille.getText().length() > 0) {
                    float Taille = Float.parseFloat(txtTaille.getText().toString());
                    float Poids = Float.parseFloat(txtpoids.getText().toString());
                    Float imc = CalculIMC(Taille, Poids);

                    // Obtenez la valeur de la balise (tag) du bouton radio sélectionné
                    int selectedSexe = rdFemme.isChecked() ? 0 : 1; // 0 pour Femme, 1 pour Homme


                    if (selectedSexe == 0) { // Femme
                        if (imc < 16) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes trop maigre");
                            lblresulta.setImageResource(R.drawable.maigreurf);
                        } else if (imc < 18.5) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes maigre");
                            lblresulta.setImageResource(R.drawable.maigreurf);
                        } else if (imc < 25) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes normale");
                            lblresulta.setImageResource(R.drawable.normalef);
                        } else if (imc < 30) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes Grosse");
                            lblresulta.setImageResource(R.drawable.surpoidsf);
                        }else if (imc < 40) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes Gros");
                            lblresulta.setImageResource(R.drawable.obesef);
                        } else {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes trés Obèse");
                            lblresulta.setImageResource(R.drawable.severef);
                        }
                    } else { // Homme
                        if (imc < 16) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes trop maigre");
                            lblresulta.setImageResource(R.drawable.maigreur);
                        } else if (imc < 18.5) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes maigre");
                            lblresulta.setImageResource(R.drawable.maigreur);
                        } else if (imc < 25) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes normale");
                            lblresulta.setImageResource(R.drawable.normale);
                        } else if (imc < 30) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes Gros");
                            lblresulta.setImageResource(R.drawable.surpoids);
                        }else if (imc < 40) {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes Gros");
                            lblresulta.setImageResource(R.drawable.obese);
                        } else {
                            result.setText("Votre IMC est: \n" + imc + " \n \n Vous êtes trés Obèse");
                            lblresulta.setImageResource(R.drawable.severe);
                        }
                    }
                }
                } else {
                    Toast.makeText(MainActivity.this, "Remplissez les champs s'il vous plaît", Toast.LENGTH_SHORT).show();
                }
            }

             boolean isChampsRemplis() {
                return txtTaille.getText().length() > 0 && txtpoids.getText().length() > 0;
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();

    }

    Float CalculIMC(float taille, float poids) {
        taille = taille / 100;
        return poids / (taille * taille);
        //float imc = poids / (taille * taille);

        //deux chiffres après la virgule
       // String imcFormate = String.format("%.2f", imc);

        // Convertir la chaîne formattée en float
        //return Float.parseFloat(imcFormate);
    }
}