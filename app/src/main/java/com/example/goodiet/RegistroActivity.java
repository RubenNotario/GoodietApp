package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RegistroActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        logo = findViewById(R.id.logo);
        logo.setImageResource(R.mipmap.ic_launcher);
    }

    public void Registrar(View view) {
        Intent login = new Intent(RegistroActivity.this, LoginMainActivity.class);
        startActivity(login);
        finish();
    }
}