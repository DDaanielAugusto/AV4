package com.example.atividadeavaliativa4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    //Lista de itens que serão exibidos e contexto da aplicação
    private List<Pizza> itemList;
    //private Context context;

    // Declaração da classe ItemAdapter, que estende RecyclerView.Adapter
    // Ela vai fornecer os itens (dados) para serem exibidos em uma RecyclerView
    public ItemAdapter(List<Pizza> itemList) {
        this.itemList = itemList;
    }

    public ItemAdapter() {

    }
    // Classe interna ViewHolder que guarda as referências dos componentes visuais de cada item
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Declaração dos elementos visuais presentes no layout do item
        ImageView imagem;
        TextView titulo;
        TextView ingredientes;
        TextView valor;
        Button btnSolicitar;

        // Construtor do ViewHolder, que encontra os elementos do layout pelo ID
        public ViewHolder(View view) {
            super(view);

            //Associa a variável ao componente ID
            imagem = view.findViewById(R.id.imagem);
            titulo = view.findViewById(R.id.titulo);
            ingredientes = view.findViewById(R.id.ingredientes);
            valor = view.findViewById(R.id.valor);
            btnSolicitar = view.findViewById(R.id.btnSolicitar);
        }
    }

    // Método chamado para criar novas views (itens da lista)
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        // Infla o layout XML para criar a interface de cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    // Método chamado para preencher os dados em cada item da lista
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position){

        Pizza pizza = itemList.get(position);
        holder.imagem.setImageResource(pizza.getImagem_id());
        holder.titulo.setText(pizza.getTitulo_id());
        holder.ingredientes.setText(pizza.getIngredientes_id());
        holder.valor.setText(pizza.getValor_id());
        Pizza principal  = itemList.get(position);
        holder.titulo.setText(principal.getTitulo_id());

        holder.btnSolicitar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Solicitacao_Activity.class);
            intent.putExtra("solicitacao-pedido", principal.getTitulo_id());
            v.getContext().startActivity(intent);
        });
    }

    // Retorna a quantidade de itens presentes na lista
    @Override
    public int getItemCount(){
        return itemList.size();
    }

}


