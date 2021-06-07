package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.goodiet.Model.Receta;

import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaRecetas;
    List<Receta> recetas = new ArrayList<>();
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipes);

        token = getIntent().getStringExtra("token");

        recetas.add(new Receta("Nombre de Receta", "Descripción", "R.drawable.logo"));
        recetas.add(new Receta("Nombre de Receta", "Descripción", "R.drawable.logo"));
        recetas.add(new Receta("Nombre de Receta", "Descripción", "R.drawable.logo"));


        listaRecetas = findViewById(R.id.listaRecetas);

        RecetaAdapter recetaAdapter = new RecetaAdapter(this, R.layout.receta, recetas);

        listaRecetas.setAdapter(recetaAdapter);
        listaRecetas.setOnItemClickListener(this);

    }

    public void AbrirPerfil(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, ProfileActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirHome(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, HomeActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirConfiguracion(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, ConfigurationActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, DetalleRecetaActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }
}