package com.example.goodiet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.goodiet.Model.Categoria;

import java.io.IOException;
import java.io.InputStream;
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


        TextView name = convertView.findViewById(R.id.name);
        name.setText(categorias.get(position).getName());


        ImageView image = convertView.findViewById(R.id.image);

        InputStream bitmap = null;
        try {
            bitmap= context.getAssets().open(categorias.get(position).getImageBmp());
            Bitmap bit=BitmapFactory.decodeStream(bitmap);
            image.setImageBitmap(bit);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}