package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalleRecetaActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    ImageView megusta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);


        megusta = findViewById(R.id.recetaFavorita);

        megusta.setOnClickListener(this);
        megusta.setOnLongClickListener(this);

    }

    public void Atras(View view) {
        Intent login = new Intent(DetalleRecetaActivity.this, ListaRecetasActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public void onClick(View view) {
        megusta.setImageResource(R.drawable.favorito);
    }

    @Override
    public boolean onLongClick(View view) {
        megusta.setImageResource(R.drawable.nofavorito);
        return false;
    }
}