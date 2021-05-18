package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecetaService {

    @GET("recipes/")
    Call<List<Receta>> getRecetas();

}
