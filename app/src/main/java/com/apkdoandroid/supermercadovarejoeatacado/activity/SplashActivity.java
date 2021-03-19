package com.apkdoandroid.supermercadovarejoeatacado.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.apkdoandroid.supermercadovarejoeatacado.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirTelaPrincipal();

            }
        },3000);
    }
    private void abrirTelaPrincipal(){
        startActivity(new Intent(this, MainActivity.class));
    }
}