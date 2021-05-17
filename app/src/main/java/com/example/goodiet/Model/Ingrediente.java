package com.example.goodiet.Model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Ingrediente {

    public String nombreIngrediente;

    public Ingrediente(String nombreIngrediente){
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

}
