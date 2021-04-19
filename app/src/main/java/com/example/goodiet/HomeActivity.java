package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaCategorias;
    Categoria[] categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categorias = new Categoria[9];
        categorias[0] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[1] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[2] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[3] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[4] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[5] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[6] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[7] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);
        categorias[8] = new Categoria("Nombre de Categoria", R.mipmap.ic_launcher);

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