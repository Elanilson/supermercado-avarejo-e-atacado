package com.apkdoandroid.supermercadovarejoeatacado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.List;

public class AdapterProdutoOferta extends RecyclerView.Adapter<AdapterProdutoOferta.MyViewHolder> {

    List<Produto> produtos;

    public AdapterProdutoOferta(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_oferta,parent,false);
        return new MyViewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
