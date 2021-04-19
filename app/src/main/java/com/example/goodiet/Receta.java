package com.example.goodiet;

import android.media.Image;

public class Receta {
    public String nombreReceta;
    public String descripcion;
    public int imagenPlato;
    public String pasos;
    public int puntuacion;
    public float tiempo;

    public Receta(String nombreReceta, String descripcion, int imagenPlato){
        this.nombreReceta = nombreReceta;
        this.descripcion = descripcion;
        this.imagenPlato = imagenPlato;
    }

}
