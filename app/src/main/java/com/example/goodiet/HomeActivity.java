package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView listaCategorias;
    Categoria[] categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categorias = new Categoria[10];
        categorias[0] = new Categoria("Vegana", R.drawable.logo);
        categorias[1] = new Categoria("Sin gluten", R.drawable.logo);
        categorias[2] = new Categoria("Alta en Proteina", R.drawable.logo);
        categorias[3] = new Categoria("Baja en grasa", R.drawable.logo);
        categorias[4] = new Categoria("China", R.drawable.logo);
        categorias[5] = new Categoria("Pastas", R.drawable.logo);
        categorias[6] = new Categoria("India", R.drawable.logo);
        categorias[7] = new Categoria("Rápidas", R.drawable.logo);
        categorias[8] = new Categoria("Nombre de Categoria", R.drawable.logo);
        categorias[9] = new Categoria("Nombre de Categoria", R.drawable.logo);

        listaCategorias = findViewById(R.id.listaCategorias);

        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(this, R.layout.categoria, categorias);

        listaCategorias.setAdapter(categoriaAdapter);
        listaCategorias.setOnItemClickListener(this);

    }


    public void AbrirPerfil(View view) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirFavoritos(View view) {
        Intent intent = new Intent(HomeActivity.this, FavoriteRecipesActivity.class);
        startActivity(intent);
        finish();
    }

    public void AbrirConfiguracion(View view) {
        Intent intent = new Intent(HomeActivity.this, ConfigurationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Intent intent = new Intent(HomeActivity.this, ListaRecetasActivity.class);
       startActivity(intent);
        finish();
    }
}