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

import com.example.goodiet.Model.Categoria;

import java.util.List;

public class CategoriaAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    List<Categoria> categorias;

    public CategoriaAdapter(@NonNull Context context, int resource, @NonNull List<Categoria> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        categorias = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }


        TextView nombreCategoria = convertView.findViewById(R.id.name);
        nombreCategoria.setText(categorias.get(position).name);

        ImageView imagenCategoria = convertView.findViewById(R.id.imageFile);
        imagenCategoria.setImageDrawable(Drawable.createFromPath("R.drawable." + categorias.get(position).imageFile));


        return convertView;
    }
}
