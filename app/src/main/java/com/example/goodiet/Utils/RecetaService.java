package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RecetaService {

    @GET("api/recipes/")
    Call<List<Receta>> getRecetas(@Header("Authorization") String auth, @Header("Content-Type") String contentType);

    @GET("api/recipes/category/{category}")
    Call<List<Receta>> getRecetasPorCategoria(@Path("category") String category, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

    @GET("api/recipes/category/{category}")
    Call<List<Receta>> getRecetasPorParametro(@Path("category") String category, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

    @GET("api/recipes/{id}" )
    Call<Receta> getReceta(@Path("id") int id, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

}
