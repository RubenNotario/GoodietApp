package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.goodiet.Model.LoginResponse;
import com.example.goodiet.Model.User;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.RegistroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    RegistroService registroService;
    EditText username;
    EditText password;
    EditText repitPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repitPassword = findViewById(R.id.repitPassword);

    }

    public void Registrar(View view) {

        User user = new User();


        if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty() && !repitPassword.getText().toString().isEmpty() &&  password.getText().toString().equals(repitPassword.getText().toString())){

            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());

            registroService = Apis.getRegisterService();
            Call<User> call=registroService.postRegistro(user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {


                    if (response.code() == 200){
                        Log.d("Respuesta Registro" , String.valueOf(response));

                        Intent login = new Intent(RegistroActivity.this, LoginMainActivity.class);
                        startActivity(login);
                        finish();

                    }else{
                        Toast.makeText(getApplicationContext(),String.valueOf(response), Toast.LENGTH_LONG ).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    Log.d("RespuestaError Registro" , t.getMessage());
                }
            });
        }else{
            Toast.makeText(getApplicationContext()," Datos erroneos", Toast.LENGTH_LONG ).show();
            Log.d("RespuestaError Registro" , "error");

        }

    }
}