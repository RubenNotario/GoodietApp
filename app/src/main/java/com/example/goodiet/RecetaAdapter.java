package com.example.goodiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecetaAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    Receta[] recetas;

    public RecetaAdapter(@NonNull Context context, int resource, @NonNull Receta[] objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        recetas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(itemLayout, parent, false);

        TextView nombreReceta = view.findViewById(R.id.nombreReceta);
        nombreReceta.setText(recetas[position].nombreReceta);

        TextView descripcion = view.findViewById(R.id.descripcion);
        descripcion.setText(recetas[position].descripcion);

        ImageView imagenPlato = view.findViewById(R.id.imagenPlato);
        imagenPlato.setImageResource(recetas[position].imagenPlato);


        return view;
    }
}
