package com.example.atividadeavaliativa4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Detalhe_Activity extends AppCompatActivity {

    Button btnSolicitar;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.item);

        btnSolicitar = findViewById(R.id.btnSolicitar);

        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalhe_Activity.this, Solicitacao_Activity.class);
                intent.putExtra("solicitacao-pedido","n1");
                Toast.makeText(Detalhe_Activity.this,"Redirecionando", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
