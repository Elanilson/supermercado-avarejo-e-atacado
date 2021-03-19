package com.apkdoandroid.supermercadovarejoeatacado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.MyViewHolder> {
    List<Produto> produtos;
    private ViewPager2 viewPager2;

    public AdapterItem(List<Produto> produtos, ViewPager2 viewPager2) {
        this.produtos = produtos;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.teste,parent ,false);

        return new MyViewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.imagem.setImageResource(produto.getImagem());


    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imagem;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imageSlide);

        }
    }
}
