package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RecuperarContrActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contr);


    }

    public void RecuperarContraseña(View view) {
        Intent login = new Intent(RecuperarContrActivity.this, LoginMainActivity.class);
        startActivity(login);
        finish();
    }
}