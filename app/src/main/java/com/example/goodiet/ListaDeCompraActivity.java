package com.example.goodiet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListaDeCompraActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ArrayList<String> ingredientes;
    ListView listadeCompra;
    EditText ingrediente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_compra);

        listadeCompra = findViewById(R.id.listadeCompra);
        ingrediente = findViewById(R.id.ingrediente);

        ingredientes = new ArrayList<>();

        IngredienteAdapter ingredienteAdapter = new IngredienteAdapter(this, R.layout.ingrediente, ingredientes);
        listadeCompra.setAdapter(ingredienteAdapter);

        listadeCompra.setOnItemLongClickListener(this);
        listadeCompra.setOnItemClickListener(this);

    }

    public void agregar(View view){
        String nombreIngrediente = ingrediente.getText().toString();

        ingredientes.add(nombreIngrediente);

        IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listadeCompra.getAdapter();
        ingredienteAdapter.notifyDataSetChanged();
    }

    public void Atras(View view) {
        Intent login = new Intent(ListaDeCompraActivity.this, ProfileActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final int posicion = i;

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("¡IMPORTANTE!");
        dialogo1.setMessage("Ya compraste ese ingrediente, ¿desea eliminarlo?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ingredientes.remove(posicion);
                IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listadeCompra.getAdapter();
                ingredienteAdapter.notifyDataSetChanged();
                Toast.makeText(ListaDeCompraActivity.this, "Operacion aceptada", Toast.LENGTH_SHORT).show();

                View vista = findViewById(R.id.vistaDeLaCompra);
                Snackbar.make(vista, "¿Quiere incluir el ingrediente en la despensa?", Snackbar.LENGTH_INDEFINITE).setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ListaDeCompraActivity.this, "Se ha incluido en la despensa", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ListaDeCompraActivity.this, "Operacion cancelada", Toast.LENGTH_SHORT).show();
            }
        });
        dialogo1.show();

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        View vista = findViewById(R.id.vistaDeLaCompra);
        Snackbar.make(vista, "Manten pulsado sobre el ingrediente para eliminarlo", Snackbar.LENGTH_LONG).show();
    }
}