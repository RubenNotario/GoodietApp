package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.example.goodiet.Model.Categoria;
import com.example.goodiet.Model.Receta;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.CategoriaService;
import com.example.goodiet.Utils.RecetaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView listaCategorias;
    List<Categoria> categorias = new ArrayList<>();
    CategoriaService categoriaService;
    CategoriaAdapter categoriaAdapter;
    EditText buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categoriaService = Apis.getCategoriaService();

        buscador = findViewById(R.id.buscador);
        listaCategorias = findViewById(R.id.listaCategorias);

        listaCategorias.setOnItemClickListener(this);

        ListarCategorias();

    }

    public void BuscarRecetas(View view) {
        if (!buscador.getText().toString().isEmpty()) {
            Intent intent = new Intent(HomeActivity.this, ListaRecetasActivity.class);
            intent.putExtra("parametro", buscador.getText().toString());
            Log.d("parametro", buscador.getText().toString());
            startActivity(intent);
            finish();
        }
    }

    public void ListarCategorias(){
        Call<List<Categoria>> call=categoriaService.getCategorias();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                categorias = response.body();
                categoriaAdapter = new CategoriaAdapter(HomeActivity.this, R.layout.categoria, categorias);
                listaCategorias.setAdapter(categoriaAdapter);
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.d("response", t.getMessage());
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
       intent.putExtra("category" , categorias.get(position).name);
        Log.d("category", categorias.get(position).name);
       startActivity(intent);
        finish();
    }

}