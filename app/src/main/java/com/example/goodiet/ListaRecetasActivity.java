package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.goodiet.Model.Receta;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.RecetaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRecetasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaRecetas;
    List<Receta> recetas = new ArrayList<>();
    RecetaAdapter recetaAdapter;
    RecetaService recetaService;
    String category;
    String parametro;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        recetaService = Apis.getRecetaService();

        listaRecetas = findViewById(R.id.listaRecetas);
        listaRecetas.setOnItemClickListener(this);

        token = getIntent().getStringExtra("token");
        category = getIntent().getStringExtra("category");
        parametro = getIntent().getStringExtra("parametro");

        if (category == null){
            ListarRecetasPorParametro();
        } else{
            ListarRecetasPorCategoria();
        }


    }

    public void ListarRecetasPorCategoria(){
        Call<List<Receta>> call=recetaService.getRecetasPorCategoria(category, "Bearer "+ token, "application/json" );
        call.enqueue(new Callback<List<Receta>>() {
            @Override
            public void onResponse(Call<List<Receta>> call, Response<List<Receta>> response) {
                recetas = response.body();
                recetaAdapter = new RecetaAdapter(ListaRecetasActivity.this, R.layout.receta, recetas);
                listaRecetas.setAdapter(recetaAdapter);
                Log.d("Recetas por categoria", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Receta>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

    public void ListarRecetasPorParametro(){
        Call<List<Receta>> call=recetaService.getRecetasPorParametro(parametro, "Bearer "+ token, "application/json");
        call.enqueue(new Callback<List<Receta>>() {
            @Override
            public void onResponse(Call<List<Receta>> call, Response<List<Receta>> response) {
                recetas = response.body();
                recetaAdapter = new RecetaAdapter(ListaRecetasActivity.this, R.layout.receta, recetas);
                listaRecetas.setAdapter(recetaAdapter);
                Log.d("parametro", parametro);
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Receta>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

    public void AbrirPerfil(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, ProfileActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirFavoritos(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, FavoriteRecipesActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirConfiguracion(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, ConfigurationActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirHome(View view) {
        Intent intent = new Intent(ListaRecetasActivity.this, HomeActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("position", String.valueOf(position));
        Intent intent = new Intent(ListaRecetasActivity.this, DetalleRecetaActivity.class);
        intent.putExtra("id", recetas.get(position).getId());
        intent.putExtra("token" , token);

        startActivity(intent);
        finish();
    }

}