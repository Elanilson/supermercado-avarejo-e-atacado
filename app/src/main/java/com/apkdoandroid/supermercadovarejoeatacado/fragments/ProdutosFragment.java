package com.apkdoandroid.supermercadovarejoeatacado.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.activity.CarrinhoActivity;
import com.apkdoandroid.supermercadovarejoeatacado.activity.ListaProdutoActivity;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterItem;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProduto;
import com.apkdoandroid.supermercadovarejoeatacado.listners.ListernesProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class ProdutosFragment extends Fragment implements ListernesProduto {


    private View view;
    private AdapterProduto adapterProduto;
    private RecyclerView recyclerViewAlimentosBasico,recyclerViewPMaisVendidos,recyclerViewHortifruti,
            recyclerViewPBebidasAlcoolicas;
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> frutas = new ArrayList<>();
    private List<Produto> alimentos = new ArrayList<>();
    private List<Produto> bebidas = new ArrayList<>();
    private List<Produto> maisvenidos = new ArrayList<>();
    private List<Produto> testes = new ArrayList<>();
    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();
    //private Produto produto = new Produto();
    private int qtd =1; // quantidade
    private TextView verTodosMaisVendidos;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_produtos, container, false);
            configurarRecycleviewMaisVendido();
            configurarRecycleviewAlimentosBasicos();
            configurarRecycleviewBebidas();
            configurarRecycleviewHortifruti();
            getVerTodosMaisVendidos();




        viewPager2 = view.findViewById(R.id.locationviewpageBanner);
        testes.add(new Produto(R.drawable.teste6));
        testes.add(new Produto(R.drawable.teste7));
        testes.add(new Produto(R.drawable.teste8));
        testes.add(new Produto(R.drawable.teste9));
        testes.add(new Produto(R.drawable.teste11));
//        testes.add(new Produto(R.drawable.banana));

        viewPager2.setAdapter(new AdapterItem(testes,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(4);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleX(0.95f + r * 0.05f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderHunnable);
                slideHandler.postDelayed(sliderHunnable,3000); // slider duração 3 segundos
            }
        });




        return view;

    }
    public void getVerTodosMaisVendidos(){
        verTodosMaisVendidos = view.findViewById(R.id.textView21VertodosMaisVendidos);
        verTodosMaisVendidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ListaProdutoActivity.class));
            }
        });

    }
    public void configurarRecycleviewMaisVendido(){
        carregarProdutos();
        recyclerViewPMaisVendidos = view.findViewById(R.id.recyclerviewProdutosMaisVendidos);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewPMaisVendidos.setLayoutManager(manager);
        adapterProduto = new AdapterProduto(maisvenidos,this);
        recyclerViewPMaisVendidos.setHasFixedSize(true);
        recyclerViewPMaisVendidos.setAdapter(adapterProduto);
    }
    public void configurarRecycleviewHortifruti(){
        carregarProdutos();
        recyclerViewHortifruti = view.findViewById(R.id.recyclerviewHortifruti);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewHortifruti.setLayoutManager(manager);
        adapterProduto = new AdapterProduto(frutas,this);
        recyclerViewHortifruti.setHasFixedSize(true);
        recyclerViewHortifruti.setAdapter(adapterProduto);
    }
    public void configurarRecycleviewBebidas(){
        carregarProdutos();
        recyclerViewPBebidasAlcoolicas = view.findViewById(R.id.recyclerviewBebidasAlcoolicas);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewPBebidasAlcoolicas.setLayoutManager(manager);
        adapterProduto = new AdapterProduto(bebidas,this);
        recyclerViewPBebidasAlcoolicas.setHasFixedSize(true);
        recyclerViewPBebidasAlcoolicas.setAdapter(adapterProduto);
    }
    public void configurarRecycleviewAlimentosBasicos(){
        carregarProdutos();
        recyclerViewAlimentosBasico = view.findViewById(R.id.recyclerviewAlimentosBasicos);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewAlimentosBasico.setLayoutManager(manager);
        adapterProduto = new AdapterProduto(alimentos,this);
        recyclerViewAlimentosBasico.setHasFixedSize(true);
        recyclerViewAlimentosBasico.setAdapter(adapterProduto);
    }
    private void carregarProdutos(){
        Produto produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        maisvenidos.add(produto);
        produto = new Produto("Pytaia",4.19,R.drawable.fruta1,1);
        maisvenidos.add(produto);
        produto = new Produto("Arroz tipo 1 1kg",4.58,R.drawable.alimento2,1);
        maisvenidos.add(produto);
        produto = new Produto("Tang laranja 25g",0.75,R.drawable.refri2,1);
        maisvenidos.add(produto);
        produto = new Produto("Açúcar UNIÃO 1kg",2.59,R.drawable.alimento4,1);
        maisvenidos.add(produto);
        produto = new Produto("Abacate",2.99,R.drawable.fruta2,1);
        maisvenidos.add(produto);
        produto = new Produto("Banana nanica",4.99,R.drawable.banana,1);
        maisvenidos.add(produto);

        Produto fruta = new Produto("Abacate",4.99,R.drawable.fruta2,0);
        frutas.add(fruta);
        fruta = new Produto("Pytaia",4.19,R.drawable.fruta1,0);
        frutas.add(fruta);
        fruta = new Produto("Banana nanica",4.99,R.drawable.banana,0);
        frutas.add(fruta);
        fruta = new Produto("Melancia",4.99,R.drawable.fruta3,0);
        frutas.add(fruta);
        fruta = new Produto("Pera",3.99,R.drawable.fruta4,0);
        frutas.add(fruta);
        fruta = new Produto("Abacate",2.99,R.drawable.fruta2,0);
        frutas.add(fruta);
        fruta = new Produto("Banana nanica",2.99,R.drawable.banana,0);
        frutas.add(fruta);
        fruta = new Produto("Pera",5.99,R.drawable.fruta4,0);
        frutas.add(fruta);

        Produto alimento = new Produto("Feijão Carioca 1 Kg",7.99,R.drawable.alimento1,0);
        alimentos.add(alimento);
        alimento = new Produto("Arroz tipo 1 1kg",4.58,R.drawable.alimento2,0);
        alimentos.add(alimento);
        alimento = new Produto("Farinha de Milho 500g",5.15,R.drawable.alimento3,0);
        alimentos.add(alimento);
        alimento = new Produto("Açúcar UNIÃO 1kg",2.59,R.drawable.alimento4,0);
        alimentos.add(alimento);
        alimento = new Produto("Óleo SOYA 900ml",4.99,R.drawable.alimento5,0);
        alimentos.add(alimento);

        Produto bebida = new Produto("Coca cola 2L",5.99,R.drawable.refri1,0);
        bebidas.add(bebida);
        bebida = new Produto("Tang laranja 25g",0.75,R.drawable.refri2,0);
        bebidas.add(bebida);
        bebida = new Produto("Dafruta premium uva 1L",1.50,R.drawable.refri3,0);
        bebidas.add(bebida);
        bebida = new Produto("Fanta laranja 350ml",0.99,R.drawable.refri4,0);
        bebidas.add(bebida);
        bebida = new Produto("Kero coco",4.45,R.drawable.refri5,0);
        bebidas.add(bebida);

 

    }
    private Runnable sliderHunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);

        }
    };

    public void adddCarrinhoSheetCustom(Produto produto){


        BottomSheetDialog sheetDialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialogTheme);

         View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.layout_carrinho_custom,(LinearLayout)this.view.findViewById(R.id.shetetCarrinho));

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
                produto.setQuantidade(qtd);
                quantidade.setText(""+qtd);


            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                    qtd--;
                    produto.setQuantidade(qtd);
                    quantidade.setText(""+qtd);

                }


            }
        });
        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtd > 0){
                    Intent intent = new Intent(getActivity(), CarrinhoActivity.class);
                    intent.putExtra("produto",produto);
                    startActivity(intent);

                }else{
                    Toast.makeText(getActivity(), "Por favor, selecione uma quantidade!! :"+qtd, Toast.LENGTH_SHORT).show();
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