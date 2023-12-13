package com.example.spacesport1.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacesport1.R;

public class menuPrincipal extends AppCompatActivity {

    Button boton2, boton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        boton2 = findViewById(R.id.BotonBoxeo);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoxeoPrincipal.class);
                startActivity(intent);
            }
        });

        boton3 = findViewById(R.id.BotonTaekwondo);


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TaekwondoPrincipal.class);
                startActivity(intent);
            }
        });



    }
}