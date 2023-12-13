package com.example.spacesport1.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.spacesport1.R;

public class PruebaConocimiento_Taekwondo extends AppCompatActivity {


    int score = 0;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3;

    Button resultado, salir;

    private TextView resultado1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_conocimiento_taekwondo);

        radioGroup1 = findViewById(R.id.radiogroupTae1);
        radioGroup2 = findViewById(R.id.radiogroupTae2);
        radioGroup3 = findViewById(R.id.radiogroupTae3);

        resultado = findViewById(R.id.mostrarResultadoButton);
        salir = findViewById(R.id.salirButton);

        resultado1 = findViewById(R.id.resultadoTextView);

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 1;


                int selectedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
                if (selectedRadioButtonId1 == R.id.opcionCorrect1) {
                    score++;
                }

                // Comprueba las selecciones de RadioButton en el segundo RadioGroup
                int selectedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                if (selectedRadioButtonId2 == R.id.opcionCorrecta2) {
                    score++;
                }

                // Comprueba las selecciones de RadioButton en el tercer RadioGroup
                int selectedRadioButtonId3 = radioGroup3.getCheckedRadioButtonId();
                if (selectedRadioButtonId3 == R.id.opcionCorrecta2) {
                    score++;
                }

                if (score == 0) {
                    // Mostrar un mensaje si no se seleccionó ninguna respuesta
                    resultado1.setText("No has seleccionado ninguna respuesta.");
                } else {
                    // Muestra la puntuación en el TextView
                    resultado1.setText("Puntuación: " + score);
                }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}