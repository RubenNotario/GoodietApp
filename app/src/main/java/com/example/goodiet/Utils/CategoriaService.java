package com.example.goodiet.Utils;

import com.example.goodiet.Model.Categoria;
import com.example.goodiet.Model.Receta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaService {

    @GET("categories/")
    Call<List<Categoria>> getCategorias();

}
