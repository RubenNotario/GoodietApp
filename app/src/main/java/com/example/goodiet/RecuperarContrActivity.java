package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class RecuperarContrActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contr);

        logo = findViewById(R.id.logo);
        logo.setImageResource(R.mipmap.ic_launcher);
    }
}