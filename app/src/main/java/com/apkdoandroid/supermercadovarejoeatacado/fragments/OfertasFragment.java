package com.apkdoandroid.supermercadovarejoeatacado.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProduto;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProdutoOferta;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class OfertasFragment extends Fragment {

    private  View view;
    private List<Produto> produtos = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterProdutoOferta adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ofertas, container, false);
        configurarRecycleviewMaisVendido();



        return  view;
    }
    public void configurarRecycleviewMaisVendido(){
        carregarProdutos();
        recyclerView = view.findViewById(R.id.recyclerviewProdutosOfertas);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
       // manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        adapter = new AdapterProdutoOferta(produtos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
    private void carregarProdutos(){
        Produto produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,0);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        produtos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,0);
        produtos.add(produto);


    }
}