package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaRecetasActivity extends AppCompatActivity {

    ListView listaRecetas;
    Receta[] recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

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
    }
}