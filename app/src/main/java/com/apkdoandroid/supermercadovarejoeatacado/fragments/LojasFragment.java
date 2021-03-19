package com.apkdoandroid.supermercadovarejoeatacado.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkdoandroid.supermercadovarejoeatacado.R;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterItem;
import com.apkdoandroid.supermercadovarejoeatacado.adapter.AdapterProduto;
import com.apkdoandroid.supermercadovarejoeatacado.model.Produto;

import java.util.ArrayList;
import java.util.List;


public class LojasFragment extends Fragment {
    private View view;
    private AdapterProduto adapterProduto;
    private RecyclerView recyclerViewAlimentosBasico,recyclerViewPMaisVendidos,recyclerViewHortifruti,
            recyclerViewPBebidasAlcoolicas;
    private List<Produto> produtos = new ArrayList<>();
    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lojas, container, false);
        viewPager2 = view.findViewById(R.id.locationviewpage);
        produtos.add(new Produto(R.drawable.banana));
        produtos.add(new Produto(R.drawable.banana));
        produtos.add(new Produto(R.drawable.banana));
        produtos.add(new Produto(R.drawable.banana));
        produtos.add(new Produto(R.drawable.banana));
        produtos.add(new Produto(R.drawable.banana));
        viewPager2.setAdapter(new AdapterItem(produtos,viewPager2));
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


        return  view;
    }
    private Runnable sliderHunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);

        }
    };
}