package com.example.goodiet;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        AlertDialog.Builder dialogoCerrarSesion = new AlertDialog.Builder(this);
        dialogoCerrarSesion.setTitle("CERRAR SESION");
        dialogoCerrarSesion.setMessage("¿Quiere cerrar sesion?");
        dialogoCerrarSesion.setCancelable(false);
        dialogoCerrarSesion.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent login = new Intent(ProfileActivity.this, LoginMainActivity.class);
                startActivity(login);
                finish();
                Toast.makeText(ProfileActivity.this, "Sesion correctamente cerrada", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoCerrarSesion.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ProfileActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoCerrarSesion.show();
    }
}