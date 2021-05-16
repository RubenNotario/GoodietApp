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

public class ListaRecetasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaRecetas;
    List<Receta> recetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));
        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));
        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));
        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));
        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));
        recetas.add(new Receta("Nombre de Receta", "Descripción", R.drawable.logo));

        listaRecetas = findViewById(R.id.listaRecetas);

        RecetaAdapter recetaAdapter = new RecetaAdapter(this, R.layout.receta, recetas);

        listaRecetas.setAdapter(recetaAdapter);
        listaRecetas.setOnItemClickListener(this);

    }



    public void AbrirPerfil(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirFavoritos(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, FavoriteRecipesActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirConfiguracion(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, ConfigurationActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirHome(View view) {
        Intent login = new Intent(ListaRecetasActivity.this, HomeActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ListaRecetasActivity.this, DetalleRecetaActivity.class);
        startActivity(intent);
        finish();
    }

}