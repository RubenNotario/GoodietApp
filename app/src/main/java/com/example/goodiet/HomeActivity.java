package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.goodiet.Model.Categoria;
import com.example.goodiet.Model.Receta;
import com.example.goodiet.Utils.RecetaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView listaCategorias;
    List<Categoria> categorias = new ArrayList<>();
    RecetaService recetaService;
    List<Receta> listaRecetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categorias.add(new Categoria("Vegana", R.drawable.logo)) ;
        categorias.add(new Categoria("Baja en grasa", R.drawable.logo)) ;
        categorias.add(new Categoria("Alta en proteina", R.drawable.logo)) ;
        categorias.add(new Categoria("Sin gluten", R.drawable.logo)) ;
        categorias.add(new Categoria("Baja en carbohidratos", R.drawable.logo)) ;
        categorias.add(new Categoria("Comida china", R.drawable.logo)) ;
        categorias.add(new Categoria("Comida India", R.drawable.logo)) ;
        categorias.add(new Categoria("Comida Española", R.drawable.logo)) ;

        listaCategorias = findViewById(R.id.listaCategorias);
        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(this, R.layout.categoria, categorias);

        listaCategorias.setAdapter(categoriaAdapter);
        listaCategorias.setOnItemClickListener(this);

    }

    public void BuscarRecetas(View view) {

    }

    public void ListarRecetas(){
        Call<List<Receta>> call=recetaService.getReceta();
        call.enqueue(new Callback<List<Receta>>() {
            @Override
            public void onResponse(Call<List<Receta>> call, Response<List<Receta>> response) {
                listaRecetas= response.body();
                Intent intent = new Intent(HomeActivity.this, ListaRecetasActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<List<Receta>> call, Throwable t) {

            }
        });

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