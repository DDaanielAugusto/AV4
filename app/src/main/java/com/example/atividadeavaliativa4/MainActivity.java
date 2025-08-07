package com.example.atividadeavaliativa4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private Button entrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        entrar = findViewById(R.id.entrar);

        SharedPreferences sharedPref = getSharedPreferences("MeuAppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPref.getBoolean("isLoggedIn", false);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nome.getText().toString().trim();

                if (!username.isEmpty()) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Seja Bem-Vindo ao aplicativo pizzaria!", Toast.LENGTH_SHORT).show();
                    navigateToMain();
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void navigateToMain() {
        Intent intent = new Intent(MainActivity.this, Cards_Principal.class);
        startActivity(intent);
    }
}
