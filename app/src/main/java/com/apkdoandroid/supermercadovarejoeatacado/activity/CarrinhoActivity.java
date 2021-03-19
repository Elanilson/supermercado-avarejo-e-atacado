package com.apkdoandroid.supermercadovarejoeatacado.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProdutoCarrinho;
import com.apkdoandroid.supermercadovarejoeatacado.listners.ListernesProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity implements ListernesProduto {

    /*
     toolbar reque android LOlipop

     */

    private RecyclerView recyclerView;
    private AdapterProdutoCarrinho adapter;
    private List<Produto> produtos = new ArrayList<>();
    private Produto produto = new Produto();
    private int qtd = 1; // quantidade
    private LinearLayout linearLayouttotal;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Toolbar toolbar = findViewById(R.id.toolbarCarrinho);
        linearLayouttotal =findViewById(R.id.linearLayoutTotal);
        toolbar.setTitle("Carrinho de Compras");
//        toolbar.setTitleMargin(200,0,200,0);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24);
        setSupportActionBar(toolbar);



        recuperrandoProdutos();
        configuraraRecycleview();



    }

    private void configuraraRecycleview() {

               if(produtos.size() >=1) {
                   linearLayouttotal.setVisibility(View.VISIBLE);
                   adapter = new AdapterProdutoCarrinho(produtos, this);
                   recyclerView = findViewById(R.id.recyclerviewCarrinhoProduto);
                   LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                   layoutManager.setOrientation(RecyclerView.VERTICAL);
                   recyclerView.setLayoutManager(layoutManager);
                   recyclerView.setHasFixedSize(true);
                   recyclerView.setAdapter(adapter);

               }


    }

    private void carregarProdutos() {
        Produto produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
        produto = new Produto("Banana nanin", 4.99, R.drawable.banana, 0);
        produtos.add(produto);
    }

    public void recuperrandoProdutos() {
        /*
             A maneira mais simples de fazer a passagem de objetos entre Activities é fazer com que eles implementem a interface java.io.Serializable.
            Dessa forma você pode passar os objetos da classe activities via Intent normalmente, inclusive adicionando-os a listas (a classe ArrayList é serializada).
         */
        produto = (Produto) getIntent().getSerializableExtra("produto");
        if(produto != null){
            produtos.add(produto);
        }
        /*
             Você deve implementar a interface Serializable no seu objeto. Ao passar na intent, coloque normalmente a lista de objetos.
              Para recuperar o objeto basta apenas utilizar "getSerializableExtra".
         */

    }
    private  void adicionarQuandidadeProduto(){
        qtd ++;
        produto.setQuantidade(qtd);
        adapter.notifyDataSetChanged();


    }
    private  void removerQuandidadeProduto(){
        if(qtd > 0){
            qtd --;
            produto.setQuantidade(qtd);
            adapter.notifyDataSetChanged();


        }

    }



    @Override
    public void onClick(Produto produto, View view) {
        switch (view.getId()){
            case R.id.buttonMaisProdutoCarrinho:
                adicionarQuandidadeProduto();
                break;
            case R.id.buttonMenosProdutoCarrinho:
                removerQuandidadeProduto();
                break;
        }






    }

    @Override
    protected void onPause() {
        super.onPause();
        produtos.clear();
    }
}