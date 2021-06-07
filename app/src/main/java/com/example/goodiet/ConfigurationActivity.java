package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

    }

    public void Atras(View view) {
        Intent intent = new Intent(ConfigurationActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}