package com.apkdoandroid.supermercadovarejoeatacado.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private Long id;
    private String titulo;
    private String descricao;
    private double preco;
    private String urlImagem;
    private  int imagem;
    private int quantidade;
    private int maisVendido = 0;

    public Produto() {
    }

    public Produto(String titulo, double preco, int imagem, int maisVendido) {
        this.titulo = titulo;
        this.preco = preco;
        this.imagem = imagem;
        this.maisVendido = maisVendido;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", urlImagem='" + urlImagem + '\'' +
                ", imagem=" + imagem +
                ", maisVendido=" + maisVendido +
                '}';
    }

    public Produto(int imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaisVendido() {
        return maisVendido;
    }

    public void setMaisVendido(int maisVendido) {
        this.maisVendido = maisVendido;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }



}
