package com.apkdoandroid.supermercadovarejoeatacado.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.listners.ListernesProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.List;

public class AdapterProdutoCarrinho extends RecyclerView.Adapter<AdapterProdutoCarrinho.MyviewHolder> {
    List<Produto> produtos;
    ListernesProduto listernesProduto;


    public AdapterProdutoCarrinho(List<Produto> produtos, ListernesProduto listernesProduto) {
        this.produtos = produtos;
        this.listernesProduto = listernesProduto;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_carrinho,parent,false);
        return new MyviewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.imagem.setImageResource(produto.getImagem());
        holder.titulo.setText(produto.getTitulo());
        holder.preco.setText("R$: "+produto.getPreco());
        holder.quantidade.setText(""+produto.getQuantidade());
        holder.btnmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listernesProduto.onClick(produtos.get(position),v);
            }
        });
        holder.btnmais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listernesProduto.onClick(produtos.get(position),v);
            }
        });
        holder.checkBoxSelecionado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{
        private TextView titulo , preco;
        private EditText quantidade;
        private Button btnmenos, btnmais;
        private CheckBox checkBoxSelecionado;
        private ImageView imagem;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textViewTituloProdutoCarrinho);
            preco = itemView.findViewById(R.id.textViewPrecoProdutoCarrinho);
            quantidade = itemView.findViewById(R.id.editQuantidadeProdutoCarrinho);
            btnmais = itemView.findViewById(R.id.buttonMaisProdutoCarrinho);
            btnmenos = itemView.findViewById(R.id.buttonMenosProdutoCarrinho);
            checkBoxSelecionado = itemView.findViewById(R.id.checkBoxSelecaoProdutoCarrinho);
            imagem = itemView.findViewById(R.id.imageViewImagemProdutoCarrinho);
        }
    }
}
