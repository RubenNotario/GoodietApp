package com.example.goodiet.Utils;


import com.example.goodiet.Model.LoginResponse;
import com.example.goodiet.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login")
    Call<LoginResponse> postLogin(@Body User user);
}
