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

        listaRecetas = findViewById(R.id.listaRecetas);

        recetas.add(new Receta("Pollo Teriyaki", "El pollo teriyaki es uno de los platos japoneses con más adeptos en el mundo. A diferencia de otros, como por ejemplo el sushi, es relativamente sencillo de hacer. A continuación te guiaremos paso a paso en su preparación.", "polloteriyaki.bmp"));
        recetas.add(new Receta("Rollitos de pollo", "Fácil y divertido. Con un poco de imaginación siempre se podrá disfrutar de platos deliciosos sin pasar horas cocinando. Plato perfecto para llevar a clases, bastante ligero y rápido de preparar.", "rollitospollo.bmp"));
        recetas.add(new Receta("Carne guisada", "Nadie se puede resistir a los ricos guisados en invierno, porque la verdad es que cuando llegan los meses fríos del año lo que apetece comer son platos de cucharas y calientes como cremas, estofados o guisos.", "carneguisada.bmp"));
        RecetaAdapter recetaAdapter = new RecetaAdapter(FavoriteRecipesActivity.this, R.layout.receta, recetas);
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