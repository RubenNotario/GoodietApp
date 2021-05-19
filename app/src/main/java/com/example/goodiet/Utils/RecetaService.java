package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecetaService {

    @GET("recipes/")
    Call<List<Receta>> getRecetas();

    @GET("recipes/buscar/category/{category}")
    Call<List<Receta>> getRecetasPorCategoria(@Path("category") String category);

    @GET("recipes/{id}" )
    Call<Receta> getReceta(@Path("id") int id);

}
