package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMainActivity extends AppCompatActivity {

    EditText username;
    EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        username = findViewById(R.id.username);
        contraseña = findViewById(R.id.contraseña);

    }

    public void Logear(View view) {

            Intent login = new Intent(LoginMainActivity.this, HomeActivity.class);
            startActivity(login);
            finish();
        }

    public void Registrar(View view) {
        Intent login = new Intent(LoginMainActivity.this, RegistroActivity.class);
        startActivity(login);
        finish();
    }
}