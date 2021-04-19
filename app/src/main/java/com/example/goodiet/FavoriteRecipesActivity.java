package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FavoriteRecipesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaRecetas;
    Receta[] recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipes);

        recetas = new Receta[9];
        recetas[0] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[1] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[2] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[3] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[4] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[5] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[6] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[7] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);
        recetas[8] = new Receta("Nombre de Receta", "Descripción", R.mipmap.ic_launcher);

        listaRecetas = findViewById(R.id.listaRecetas);

        RecetaAdapter recetaAdapter = new RecetaAdapter(this, R.layout.receta, recetas);

        listaRecetas.setAdapter(recetaAdapter);
        listaRecetas.setOnItemClickListener(this);

    }

    public void AbrirPerfil(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirHome(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirConfiguracion(View view) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, ConfigurationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(FavoriteRecipesActivity.this, DetalleRecetaActivity.class);
        startActivity(intent);
        finish();
    }
}