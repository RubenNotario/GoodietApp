package com.example.goodiet;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        token = getIntent().getStringExtra("token");

    }

    public void Atras(View view) {
        Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void CambiarNombre(View view) {
        Intent intent = new Intent(ProfileActivity.this, NameChangeActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirDespensa(View view) {
        Intent intent = new Intent(ProfileActivity.this, DespensaActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    public void AbrirListaCompra(View view) {
        Intent intent = new Intent(ProfileActivity.this, ListaDeCompraActivity.class);
        intent.putExtra("token" , token);
        startActivity(intent);
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
                Intent intent = new Intent(ProfileActivity.this, LoginMainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ProfileActivity.this, "Sesion finalizada correctamente", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoCerrarSesion.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ProfileActivity.this, "Operacion cancelada", Toast.LENGTH_SHORT).show();
            }
        });
        dialogoCerrarSesion.show();
    }
}