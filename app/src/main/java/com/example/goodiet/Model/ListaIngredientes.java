package com.example.goodiet.Model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaIngredientes {

    public ArrayList<String> ingredientes;

    public ListaIngredientes() {
        ingredientes = new ArrayList<>();
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListaIngredientes fromJson(String json){
        Gson gson = new Gson();
        ListaIngredientes listaIngredientes = gson.fromJson(json, ListaIngredientes.class);
        return listaIngredientes;
    }




}
