package com.example.goodiet.Model;

public class Categoria {

    public String nombreCategoria;
    public int imagenCategoria;

    public Categoria(String nombreCategoria, int imagenCategroia){
        this.nombreCategoria = nombreCategoria;
        this.imagenCategoria = imagenCategroia;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(int imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }
}
