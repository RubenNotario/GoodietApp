package com.example.goodiet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.goodiet.Model.Receta;

import java.util.List;

public class RecetaAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Receta> recetas;

    public RecetaAdapter(@NonNull Context context, int resource, @NonNull List<Receta> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        recetas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }


        TextView name = convertView.findViewById(R.id.name);
        name.setText(recetas.get(position).getName());

        TextView descripcion = convertView.findViewById(R.id.descripcion);
        descripcion.setText(recetas.get(position).getDescripcion());

        ImageView imageFile = convertView.findViewById(R.id.imageFile);
        imageFile.setImageDrawable(Drawable.createFromPath("R.drawable." + recetas.get(position).getImageFile()));


        return convertView;
    }
}
