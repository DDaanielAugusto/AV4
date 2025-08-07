package com.example.atividadeavaliativa4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Cards_Principal extends AppCompatActivity {

    // Declaração do RecyclerView que exibirá as pizzas
    private RecyclerView recyclerView;

    // Declaração do adapter responsável por ligar os dados ao RecyclerView
    private ItemAdapter adapter;

    // Lista que armazenará os itens
    private List<Pizza> ItensPizza;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cards_principal);

        // Encontra o RecyclerView no layout pelo ID "recyclerView"
        recyclerView = findViewById(R.id.recyclerView);
        //Definição de layout vertical como lista
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Cria uma nova lista de itens
        ItensPizza = new ArrayList<>();

        // Adiciona pizzas (com imagem, título, ingredientes e valor) à lista
        ItensPizza.add(new Pizza(R.drawable.pizza, "Pizza Portuguesa", "Molhos, tomate, cebola, azeitona", "R$35,19"));
        ItensPizza.add(new Pizza(R.drawable.pizza2, "Pizza Calabresa e Queijo", "Molho, calabresa, queiro, cebola e temperos.", "R$47,59"));
        ItensPizza.add(new Pizza(R.drawable.pizza3, "Pizza Quatro Queijos", "Queijo calabresa, mineiro, italiano, francês", "R$66,99"));
        ItensPizza.add(new Pizza(R.drawable.pizza4, "PizzaCatupiry e Calabrsa", "Calabresa, cheddar, catupiry e molhos", "R$45,99"));

        // Cria o adapter passando o contexto (this) e a lista de pizzas
        adapter = new ItemAdapter(ItensPizza);

        // Define o adapter no RecyclerView, ligando os dados à interface
        recyclerView.setAdapter(adapter);
    }
}
