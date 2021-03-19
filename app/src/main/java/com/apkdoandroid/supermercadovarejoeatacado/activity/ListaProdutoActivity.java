package com.apkdoandroid.supermercadovarejoeatacado.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProduto;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProdutoCarrinho;
import com.apkdoandroid.supermercadovarejoeatacado.listners.ListernesProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutoActivity extends AppCompatActivity implements ListernesProduto {
    private RecyclerView recyclerView;
    private AdapterProduto adapter;
    private List<Produto> produtos = new ArrayList<>();
    private int qtd =1; // quantidade

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);
        configuraraRecycleview();

        Toolbar toolbar = findViewById(R.id.toolbarListaProduto);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24);
        toolbar.setTitle("Produtos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void configuraraRecycleview (){
        carregarProdutos();
        adapter = new AdapterProduto(produtos,this);
        recyclerView = findViewById(R.id.recyclerViewListaProduto);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    private void carregarProdutos(){
        Produto produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanin",4.99,R.drawable.banana,0);
        produtos.add(produto);
    }
    public void adddCarrinhoSheetCustom(Produto produto){


        BottomSheetDialog sheetDialog = new BottomSheetDialog(this,R.style.BottomSheetDialogTheme);

        View view = LayoutInflater.from(this)
                .inflate(R.layout.layout_carrinho_custom,(LinearLayout)findViewById(R.id.shetetCarrinho));

        ImageView imagem = view.findViewById(R.id.imageViewImageSelecCarrinho);
        TextView titulo = view.findViewById(R.id.textViewtituloSelecCarrinho);
        TextView preco = view.findViewById(R.id.textViewPrecoSelecCarrinho);
        TextView estoque = view.findViewById(R.id.textViewEstoqueSelecCarrinho);
        Button mais = view.findViewById(R.id.buttonMaisSelecCarrinho);
        Button menos = view.findViewById(R.id.buttonMenosSelecCarrinho);
        Button carrinho = view.findViewById(R.id.buttonAdicionarSelecCarrinho);
        EditText quantidade = view.findViewById(R.id.editQuantidadeSelecCarrinho);
        quantidade.setText(""+qtd);

        atribuicarrinho(menos,mais,quantidade,titulo,preco,estoque,imagem,produto,carrinho);

        sheetDialog.setContentView(view);
        sheetDialog.setCancelable(true);
        sheetDialog.show();







    }
    public void atribuicarrinho(Button menos,Button mais,EditText quantidade,TextView titulo,TextView preco,TextView estoque, ImageView imagem,Produto produto, Button btnCarrinho){


        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtd ++;
                quantidade.setText(""+qtd);


            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                    qtd--;
                    quantidade.setText(""+qtd);

                }


            }
        });
        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                    startActivity(new Intent(ListaProdutoActivity.this, CarrinhoActivity.class));

                }else{
                    Toast.makeText(ListaProdutoActivity.this, "Por favor, selecione uma quantidade!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        titulo.setText(produto.getTitulo());
        imagem.setImageResource(produto.getImagem());
        preco.setText("R$: "+produto.getPreco());
        Log.d("Produto",produto.toString());
    }
    @Override
    public void onClick(Produto produto, View view) {
        adddCarrinhoSheetCustom(produto);

    }
}