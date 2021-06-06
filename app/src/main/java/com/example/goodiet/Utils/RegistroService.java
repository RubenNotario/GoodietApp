package com.example.goodiet.Utils;

import com.example.goodiet.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistroService {

    @POST("register")
    Call<User>postRegistro(@Body User user);

}
