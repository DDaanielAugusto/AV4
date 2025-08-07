package com.example.atividadeavaliativa4;

public class Pizza {

    //Declarações de atributos privados que armazenam o ID do recurso
    private int imagem;
    private String titulo;
    private String ingredientes;
    private String valor;

    //Construtor que recere como parâmentro o ID dos atributos declarados

    // Construtor da classe PrinciplaActivity
    // Recebe como parâmetros o ID de imagem, titulo, ingredientes e valor
    public Pizza(int imagem_id, String titulo_id, String ingredientes_id, String valor_id){
        this.imagem = imagem_id;
        this.titulo = titulo_id;
        this.ingredientes = ingredientes_id;
        this.valor = valor_id;
    }

    // Métodos Getters que retornam valores armazenados

    public int getImagem_id(){
        return imagem;
    }

    public String getTitulo_id(){
        return titulo;
    }

    public String getIngredientes_id(){
        return ingredientes;
    }

    public String getValor_id(){
        return valor;
    }
}