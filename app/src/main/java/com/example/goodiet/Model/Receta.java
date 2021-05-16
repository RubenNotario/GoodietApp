package com.example.goodiet.Model;

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

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenPlato() {
        return imagenPlato;
    }

    public void setImagenPlato(int imagenPlato) {
        this.imagenPlato = imagenPlato;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
}
