package com.example.goodiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodiet.Model.Receta;
import com.example.goodiet.Utils.Apis;
import com.example.goodiet.Utils.RecetaService;

import java.io.IOException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleRecetaActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    ImageView megusta;
    TextView steps;
    TextView name;
    TextView timeTaken;
    TextView difficulty;
    TextView rate;
    ImageView image;

    RecetaService recetaService;
    int id;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        megusta = findViewById(R.id.recetaFavorita);
        steps = findViewById(R.id.pasos);
        name = findViewById(R.id.name);
        timeTaken = findViewById(R.id.timeTaken);
        difficulty = findViewById(R.id.difficulty);
        rate = findViewById(R.id.rate);
        image = findViewById(R.id.image);

        recetaService = Apis.getRecetaService();

        token = getIntent().getStringExtra("token");
        id = getIntent().getIntExtra("id", 0);


        megusta.setOnClickListener(this);
        megusta.setOnLongClickListener(this);

        GetReceta();
    }

    public void GetReceta(){
        Call<Receta> call=recetaService.getReceta(id, "Bearer "+ token, "application/json" );
        call.enqueue(new Callback<Receta>() {

            @Override
            public void onResponse(Call<Receta> call, Response<Receta> response) {
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
                Log.d("id", String.valueOf((id)));

                steps.setText(response.body().getSteps());
                name.setText(response.body().getName());
                timeTaken.setText(String.valueOf(response.body().getTimeTaken()));
                rate.setText(String.valueOf(response.body().getRate()));
                difficulty.setText(String.valueOf(response.body().getDifficulty()));

                InputStream bitmap = null;
                try {
                    bitmap= getAssets().open("frios.bmp");
                    Bitmap bit= BitmapFactory.decodeStream(bitmap);
                    image.setImageBitmap(bit);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Receta> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

            public void Atras(View view) {
                Intent intent = new Intent(DetalleRecetaActivity.this, HomeActivity.class);
                intent.putExtra("token" , token);
                startActivity(intent);
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