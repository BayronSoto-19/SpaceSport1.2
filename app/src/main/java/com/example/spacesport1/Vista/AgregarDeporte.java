package com.example.spacesport1.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.spacesport1.Modelo.Comentario;
import com.example.spacesport1.R;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class AgregarDeporte extends AppCompatActivity {
    private EditText editTextNombreDeporte, editTextComentario;


    private Button btnAgregar;
    private ListView listViewComentarios;


    private ArrayList<Comentario> listaComentarios;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_deporte);


        editTextNombreDeporte = findViewById(R.id.editTextNombreDeporte);
        editTextComentario = findViewById(R.id.editTextComentario);
        btnAgregar = findViewById(R.id.btnAgregar);
        listViewComentarios = findViewById(R.id.listViewComentarios);


        databaseReference = FirebaseDatabase.getInstance().getReference("comentarios");
        listaComentarios = new ArrayList<>();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarComentario();
            }
        });

        // Configurar el listener para actualizar la lista cuando cambian los datos en Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaComentarios.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Comentario comentario = dataSnapshot.getValue(Comentario.class);
                    listaComentarios.add(comentario);
                }

                // Actualizar el adaptador del ListView
                // adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores
            }
        });
    }

    private void agregarComentario() {
        // Obtener datos de los EditText
        String nombreDeporte = editTextNombreDeporte.getText().toString();
        String comentarioTexto = editTextComentario.getText().toString();

        // Verificar que los campos no estén vacíos
        if (!nombreDeporte.isEmpty() && !comentarioTexto.isEmpty()) {
            // Crear un nuevo objeto Comentario
            Comentario comentario = new Comentario(nombreDeporte, comentarioTexto);

            // Obtener un nuevo ID único para el comentario en Firebase
            String comentarioId = databaseReference.push().getKey();

            // Guardar el comentario en Firebase usando el ID único
            databaseReference.child(comentarioId).setValue(comentario);

            // Limpiar los EditText después de agregar el comentario
            editTextNombreDeporte.setText("");
            editTextComentario.setText("");
        }
    }
}