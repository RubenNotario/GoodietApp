package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DespensaActivity extends AppCompatActivity {

    ArrayList<String> textos;
    ListView listaDespensa;
    EditText ingrediente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despensa);

        listaDespensa = findViewById(R.id.listaDespensa);
        ingrediente = findViewById(R.id.ingrediente);

        textos = new ArrayList<>();

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, textos);

        listaDespensa.setAdapter(adapter);

    }

    public void agregar(View view){
        String texto = ingrediente.getText().toString();
        textos.add(texto);
        ArrayAdapter adapter = (ArrayAdapter) listaDespensa.getAdapter();
        adapter.notifyDataSetChanged();
    }

    public void Atras(View view) {
        Intent login = new Intent(DespensaActivity.this, ProfileActivity.class);
        startActivity(login);
        finish();
    }
}