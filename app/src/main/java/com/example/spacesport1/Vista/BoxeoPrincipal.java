package com.example.spacesport1.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacesport1.R;

public class BoxeoPrincipal extends AppCompatActivity {

    Button boton3;
    Button boton4;
    Button boton5;

    Button boton6;

    Button boton7;

    Button boton8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxeo_principal);

        boton3 = findViewById(R.id.BotonTecnica);


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), tecnicaBox.class);
                startActivity(intent);
            }
        });

        boton4 = findViewById(R.id.BotonLicencias);


        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), licencisaBox.class);
                startActivity(intent);
            }
        });

        boton5 = findViewById(R.id.BotonHistoricos);

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), boxeadoresHistoricos.class);
                startActivity(intent);
            }
        });

        boton6 = findViewById(R.id.BotonHistoria);

        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), historiaBoxeo.class);
                startActivity(intent);
            }
        });



        boton7 = findViewById(R.id.BotonPrueba);


        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), prueba_box.class);
                startActivity(intent);
            }
        });

        boton8 = findViewById(R.id.button3);


        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapaBox.class);
                startActivity(intent);
            }
        });
    }
}