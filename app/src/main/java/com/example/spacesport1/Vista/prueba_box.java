package com.example.spacesport1.Vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacesport1.R;

public class prueba_box extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2, radioGroup3;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private Button btnCalculate, btnFinish;
    private TextView tvScore;

    int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_box);

        //Aqui estan los radio buttom
        radioGroup1 = findViewById(R.id.radiogroup1);
        radioGroup2 = findViewById(R.id.radiogroup2);
        radioGroup3 = findViewById(R.id.radiogroup3);
        //aqui estan los checkbox
        checkBox1 = findViewById(R.id.BoxJoeFrazier);
        checkBox2 = findViewById(R.id.BoxMohamed);
        checkBox3 = findViewById(R.id.BoxKenNorton);

        //calculo del resultado
        btnCalculate = findViewById(R.id.btnResultado);
        tvScore = findViewById(R.id.tvScore);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 1;

                // Comprueba las selecciones de RadioButton en el primer RadioGroup
                int selectedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
                if (selectedRadioButtonId1 == R.id.respuesta1) {
                    score++;
                }

                // Comprueba las selecciones de RadioButton en el segundo RadioGroup
                int selectedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                if (selectedRadioButtonId2 == R.id.respuesta2) {
                    score++;
                }

                // Comprueba las selecciones de RadioButton en el tercer RadioGroup
                int selectedRadioButtonId3 = radioGroup3.getCheckedRadioButtonId();
                if (selectedRadioButtonId3 == R.id.respuesta3) {
                    score++;
                }

                // Comprueba las selecciones de CheckBox
                if (checkBox1.isChecked()) {
                    score++;
                }
                if (checkBox2.isChecked()) {
                    score++;
                }
                if (checkBox3.isChecked()) {
                    score++;
                }
                if (score == 0) {
                    // Mostrar un mensaje si no se seleccionó ninguna respuesta
                    tvScore.setText("No has seleccionado ninguna respuesta.");
                } else {
                    // Muestra la puntuación en el TextView
                    tvScore.setText("Puntuación: " + score);
                }
            }
        });

        btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual
            }
        });

    }
}
