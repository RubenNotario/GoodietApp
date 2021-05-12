package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }

    public void Logear(View view) {

            Intent intent = new Intent(LoginMainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
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