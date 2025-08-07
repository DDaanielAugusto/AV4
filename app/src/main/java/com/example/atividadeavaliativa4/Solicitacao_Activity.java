package com.example.atividadeavaliativa4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Solicitacao_Activity  extends AppCompatActivity {

    TextView solicitar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.solicitacao_activity);

        this.solicitar = findViewById(R.id.btnSolicitar);

        String solicitacao  = getIntent().getStringExtra("solicitacao-pedido");

        if(solicitacao.equals("Pizza Portuguesa")){
            this.solicitar.setText("Observações no pedido:");
        }else if(solicitacao.equals("Pizza Calabresa e Queijo")){
            this.solicitar.setText("Observações no pedido:");
        }else if(solicitacao.equals("Pizza Quatro Queijos")){
            this.solicitar.setText("Observações no pedido:");
        }else{
            this.solicitar.setText("Observações no pedido:");
        }


    }
}
