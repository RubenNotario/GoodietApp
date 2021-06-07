package com.example.goodiet.Utils;

import com.example.goodiet.Model.Categoria;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface CategoriaService {


    @GET("api/categories/")
    Call<List<Categoria>> getCategorias(@Header("Authorization") String auth, @Header("Content-Type") String contentType);

}
