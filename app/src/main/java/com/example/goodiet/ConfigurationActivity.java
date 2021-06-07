package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConfigurationActivity extends AppCompatActivity {
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        token = getIntent().getStringExtra("token");
    }

    public void Atras(View view) {
        Intent intent = new Intent(ConfigurationActivity.this, HomeActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }
}