package com.apkdoandroid.supermercadovarejoeatacado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.listners.ListernesProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.List;

public class AdapterProduto  extends RecyclerView.Adapter<AdapterProduto.MyViewHolder> {
    List<Produto> produtos;
    ListernesProduto listernesProduto;

    public AdapterProduto(List<Produto> produtos, ListernesProduto listernesProduto) {
        this.produtos = produtos;
        this.listernesProduto = listernesProduto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_produto,parent ,false);

        return new MyViewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.imagem.setImageResource(produto.getImagem());
        holder.titulo.setText(produto.getTitulo());
        holder.preco.setText("R$: "+produto.getPreco());
        if(produto.getMaisVendido() == 0){
            holder.imagemMaisVendido.setVisibility(View.GONE);
        }else {

            holder.imagemMaisVendido.setVisibility(View.VISIBLE);
        }
        holder.btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listernesProduto.onClick(produto,v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagem, imagemMaisVendido;
        private TextView titulo,preco;
        private Button  btnCarrinho;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imageViewProduto);
            imagemMaisVendido = itemView.findViewById(R.id.imageViewMaisVendido);
            titulo = itemView.findViewById(R.id.textViewTituloProduto);
            preco = itemView.findViewById(R.id.textView6PrecoProduto);
            btnCarrinho = itemView.findViewById(R.id.buttonCarrinhoProduto);
        }
    }
}
