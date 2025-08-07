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
    private List<PrincipalActivity> itemList;
    private Context context;


    // Declaração da classe ItemAdapter, que estende RecyclerView.Adapter
    // Ela vai fornecer os itens (dados) para serem exibidos em uma RecyclerView
    public ItemAdapter(Cards_Principal context, List<PrincipalActivity> itemList) {
        this.context = context;
        this.itemList = itemList;
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
        public ViewHolder(View itemView) {
            super(itemView);

            //Associa a variável ao componente ID
            imagem = itemView.findViewById(R.id.imagem);
            titulo = itemView.findViewById(R.id.titulo);
            ingredientes = itemView.findViewById(R.id.ingredientes);
            valor = itemView.findViewById(R.id.valor);
            btnSolicitar = itemView.findViewById(R.id.btnSolicitar);
        }
    }

    // Método chamado para criar novas views (itens da lista)
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        // Infla o layout XML para criar a interface de cada item
        View view = LayoutInflater.from(context).inflate(R.layout.principal_activity, parent, false);
        return new ViewHolder(view);
    }

    // Método chamado para preencher os dados em cada item da lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        PrincipalActivity item = itemList.get(position);
        holder.imagem.setImageResource(item.getImagem_id());
        holder.titulo.setText(item.getTitulo_id());
        holder.ingredientes.setText(item.getIngredientes_id());
        holder.valor.setText(item.getValor_id());
        PrincipalActivity principal  = itemList.get(position);
        holder.titulo.setText(principal.getTitulo_id());


        holder.btnSolicitar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ItemAdapter.class);
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


