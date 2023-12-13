package com.example.spacesport1.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacesport1.R;

public class TaekwondoPrincipal extends AppCompatActivity {

    Button golpe, boton3, boton4, boton5, boton6, boton7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taekwondo_principal);

        golpe = findViewById(R.id.kicktae);
        golpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), golpesTaekwondo.class);
                startActivity(intent);
            }
        });

        boton3= findViewById(R.id.grados);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), golpesTaekwondo.class);
                startActivity(intent);
            }
        });

        boton4= findViewById(R.id.historico);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonasHistoricas_Taekwondo.class);
                startActivity(intent);
            }
        });

        boton5= findViewById(R.id.historiatae);
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), historiaTaekwondo.class);
                startActivity(intent);
            }
        });


        boton6= findViewById(R.id.pruebaConocimientotae);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PruebaConocimiento_Taekwondo.class);
                startActivity(intent);
            }
        });

        boton7= findViewById(R.id.mapaTae);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mapa_Taekwondo.class);
                startActivity(intent);
            }
        });
    }
}