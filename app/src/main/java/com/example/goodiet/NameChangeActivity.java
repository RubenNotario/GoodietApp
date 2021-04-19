package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NameChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_change);
    }

    public void Atras(View view) {
        Intent login = new Intent(NameChangeActivity.this, ProfileActivity.class);
        startActivity(login);
        finish();
    }
}