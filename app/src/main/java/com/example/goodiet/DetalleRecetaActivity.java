package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetalleRecetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);
    }

    public void Atras(View view) {
        Intent login = new Intent(DetalleRecetaActivity.this, ListaRecetasActivity.class);
        startActivity(login);
        finish();
    }
}