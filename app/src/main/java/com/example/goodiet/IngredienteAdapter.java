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

import com.example.goodiet.Model.Categoria;
import com.example.goodiet.Model.Ingrediente;

import java.util.ArrayList;
import java.util.List;


public class IngredienteAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    ArrayList<String> ingredientes;

    public IngredienteAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);

        this.context = context;
        itemLayout = resource;
        ingredientes = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }

        TextView nombreIngrediente = convertView.findViewById(R.id.nombreIngrediente);
        nombreIngrediente.setText(ingredientes.get(position));

        return convertView;
    }

}
