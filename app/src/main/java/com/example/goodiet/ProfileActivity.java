package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void Atras(View view) {
        Intent login = new Intent(ProfileActivity.this, HomeActivity.class);
        startActivity(login);
        finish();
    }

    public void CambiarNombre(View view) {
        Intent login = new Intent(ProfileActivity.this, NameChangeActivity.class);
        startActivity(login);
        finish();
    }

    public void AbrirDespensa(View view) {
        Intent login = new Intent(ProfileActivity.this, DespensaActivity.class);
        startActivity(login);
        finish();
    }

    public void AbrirListaCompra(View view) {
        Intent login = new Intent(ProfileActivity.this, ListaDeCompraActivity.class);
        startActivity(login);
        finish();
    }

    public void CerrarSesion(View view) {
        Intent login = new Intent(ProfileActivity.this, LoginMainActivity.class);
        startActivity(login);
        finish();
    }
}