package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goodiet.Model.LoginResponse;
import com.example.goodiet.Model.User;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMainActivity extends AppCompatActivity {

    LoginService loginService;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }

    public void Logear(View view) {

        User user = new User();

        if (!username.getText().toString().isEmpty()){
            user.setUsername(username.getText().toString());
        }else{
            username.setText("");
        }

        if (!password.getText().toString().isEmpty()){
            user.setPassword(password.getText().toString());
        }else{
            password.setText("");
        }

        loginService = Apis.getLoginService();
        Call<LoginResponse> call=loginService.postLogin(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                if (response.code() == 200){
                    Log.d("Respuesta" , response.body().getToken());
                    Log.d("Respuesta" , String.valueOf(response));

                    Intent intent = new Intent(LoginMainActivity.this, HomeActivity.class);
                    intent.putExtra("token" , response.body().getToken());
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario no encontrado", Toast.LENGTH_LONG ).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.d("Respuesta" , t.getMessage());
                Log.d("Username" , user.getUsername());
                Log.d("Password" , user.getPassword());
            }
        });

        }

    public void Registrar(View view) {
        Intent intent = new Intent(LoginMainActivity.this, RegistroActivity.class);
        startActivity(intent);
        finish();
    }

    public void RecuperarContraseña(View view) {
        Intent intent = new Intent(LoginMainActivity.this, RecuperarContrActivity.class);
        startActivity(intent);
        finish();
    }
}