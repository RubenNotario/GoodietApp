package com.example.goodiet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.goodiet.Model.Ingrediente;
import com.example.goodiet.Model.Receta;

import java.util.ArrayList;
import java.util.List;

public class DespensaActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView listaDespensa;
    EditText ingrediente;
    ArrayList<String> ingredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despensa);

        listaDespensa = findViewById(R.id.listaDespensa);
        ingrediente = findViewById(R.id.ingrediente);

        ingredientes = new ArrayList<>();

        IngredienteAdapter ingredienteAdapter = new IngredienteAdapter(this, R.layout.ingrediente, ingredientes);
        listaDespensa.setAdapter(ingredienteAdapter);

        listaDespensa.setOnItemLongClickListener(this);
    }

    public void agregar(View view){
        String nombreIngrediente = ingrediente.getText().toString();

        ingredientes.add(nombreIngrediente);

        IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listaDespensa.getAdapter();
        ingredienteAdapter.notifyDataSetChanged();

    }

    public void Atras(View view) {
        Intent login = new Intent(DespensaActivity.this, ProfileActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final int posicion = i;

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("¡IMPORTANTE!");
        dialogo1.setMessage("Ya no tienes ese ingrediente, ¿desea eliminarlo?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ingredientes.remove(posicion);
                IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listaDespensa.getAdapter();
                ingredienteAdapter.notifyDataSetChanged();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DespensaActivity.this, "Operacion cancelada", Toast.LENGTH_LONG).show();
            }
        });
        dialogo1.show();

        return false;
    }

}