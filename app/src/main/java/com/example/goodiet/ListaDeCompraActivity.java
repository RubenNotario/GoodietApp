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

import com.example.goodiet.Model.ListaIngredientes;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListaDeCompraActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ListaIngredientes listaIngredientes;
    ListView listadeCompra;
    EditText ingrediente;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_compra);
        //Busqueda de vistas del layout.
        listadeCompra = findViewById(R.id.listadeCompra);
        ingrediente = findViewById(R.id.ingrediente);
        //creacion funciones de clicks.
        listadeCompra.setOnItemLongClickListener(this);
        listadeCompra.setOnItemClickListener(this);
        //Almacenar-obtener preferencias.
        sharedPreferences = getSharedPreferences("ALMACEN2", MODE_PRIVATE);
        //obtener y enseñar el dato guardado.
        String ingredientesAñadidos = sharedPreferences.getString("ingredientesAñadidos","");
        if(!ingredientesAñadidos.isEmpty()){
            listaIngredientes = new ListaIngredientes();
            listaIngredientes = listaIngredientes.fromJson(ingredientesAñadidos);
        }else{
            listaIngredientes = new ListaIngredientes();
        }
        //Integracion adapter con la lista.
        IngredienteAdapter ingredienteAdapter = new IngredienteAdapter(this, R.layout.ingrediente, listaIngredientes.ingredientes);
        listadeCompra.setAdapter(ingredienteAdapter);

    }

    //Funcion para agregar elementos a la lista.
    public void agregar(View view){
        String nombreIngrediente = ingrediente.getText().toString();

        listaIngredientes.ingredientes.add(nombreIngrediente);

        IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listadeCompra.getAdapter();
        ingredienteAdapter.notifyDataSetChanged();

        //momento en el que se guardan las preferencias.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ingredientesAñadidos", listaIngredientes.toJson());
        editor.apply();
        //limpiar buscador.
        ingrediente.setText("");
    }
    //Funcion para ir a la pantalla anterior.
    public void Atras(View view) {
        Intent login = new Intent(ListaDeCompraActivity.this, ProfileActivity.class);
        startActivity(login);
        finish();
    }

    //Funcion para eliminar el ingrediente.
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final int posicion = i;
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("¡IMPORTANTE!");
        dialogo1.setMessage("¿Desea eliminar el ingrediente? El ingrediente se eliminara automaticamente.");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //borrar ingrediente
                listaIngredientes.ingredientes.remove(posicion);
                IngredienteAdapter ingredienteAdapter = (IngredienteAdapter) listadeCompra.getAdapter();
                ingredienteAdapter.notifyDataSetChanged();
                //momento en el que se guardan las preferencias.
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ingredientesAñadidos", listaIngredientes.toJson());
                editor.apply();
                Toast.makeText(ListaDeCompraActivity.this, "Ingrediente eliminado de la lista de compra", Toast.LENGTH_SHORT).show();
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

    //Funcion explicativa del proceso de eliminacion.
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        View vista = findViewById(R.id.vistaDeLaCompra);
        Snackbar.make(vista, "Manten pulsado sobre el ingrediente para eliminarlo", Snackbar.LENGTH_LONG).show();
    }
}