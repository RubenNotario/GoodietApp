package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodiet.Model.Receta;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.RecetaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleRecetaActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    ImageView megusta;
    TextView pasos;
    TextView name;
    TextView time;
    RecetaService recetaService;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        megusta = findViewById(R.id.recetaFavorita);
        pasos = findViewById(R.id.pasos);
        name = findViewById(R.id.name);
        time = findViewById(R.id.timeTaken);


        recetaService = Apis.getRecetaService();

        id = getIntent().getIntExtra("id", 0);


        megusta.setOnClickListener(this);
        megusta.setOnLongClickListener(this);

        GetReceta();
    }

    public void GetReceta(){
        Call<Receta> call=recetaService.getReceta(id);
        call.enqueue(new Callback<Receta>() {

            @Override
            public void onResponse(Call<Receta> call, Response<Receta> response) {
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
                Log.d("id", String.valueOf((id)));

                pasos.setText(response.body().getPasos());
                name.setText(response.body().getName());
                time.setText(response.body().getTimeTaken());
            }

            @Override
            public void onFailure(Call<Receta> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

            public void Atras(View view) {
        Intent login = new Intent(DetalleRecetaActivity.this, HomeActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public void onClick(View view) {
        megusta.setImageResource(R.drawable.favorito);
    }

    @Override
    public boolean onLongClick(View view) {
        megusta.setImageResource(R.drawable.nofavorito);
        return false;
    }
}