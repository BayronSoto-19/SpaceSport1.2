package com.example.spacesport1.Vista;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacesport1.R;
import com.example.spacesport1.controlador.ConexionHelper;
import com.example.spacesport1.controlador.Utility;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout emailTextInputLayout, passwordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        // Obtén las referencias de TextInputLayout
        emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Valida el correo electrónico y la contraseña
                if (validateForm()) {
                    String email = emailTextInputLayout.getEditText().getText().toString().trim();
                    String password = passwordTextInputLayout.getEditText().getText().toString().trim();

                    // Aquí debes implementar la lógica para verificar las credenciales
                    if (isValidCredentials(email, password)) {
                        // Iniciar sesión exitosamente
                        startActivity(new Intent(MainActivity.this, menuPrincipal.class));
                        // Muestra un mensaje de confirmación
                        Toast.makeText(MainActivity.this, "¡Iniciaste sesión correctamente!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Muestra un mensaje de error si las credenciales son incorrectas
                        Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad de registro cuando se presiona el botón "Registrarse"
                startActivity(new Intent(MainActivity.this, activity_Register.class));
            }
        });
    }

    // Función para validar los campos del formulario de inicio de sesión
    private boolean validateForm() {
        boolean isValid = true;

        String email = emailTextInputLayout.getEditText().getText().toString().trim();
        String password = passwordTextInputLayout.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            emailTextInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            passwordTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            passwordTextInputLayout.setError(null);
        }

        return isValid;
    }

    private boolean isValidCredentials(String email, String password) {
        ConexionHelper conn = new ConexionHelper(this, "SpaceSport1.db", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            String[] columns = {Utility.CAMPO_CONTRASENA};
            String selection = Utility.CAMPO_CORREO + "=?";
            String[] selectionArgs = {email};

            Cursor cursor = db.query(Utility.TABLA_USUARIO, columns, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                String storedPassword = cursor.getString(cursor.getColumnIndex(Utility.CAMPO_CONTRASENA));
                cursor.close();
                return password.equals(storedPassword);
            } else {
                cursor.close();
                return false;
            }
        } finally {
            db.close();
        }
    }
}