package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;

public class Apis {

    public static final String URL_001="http://127.0.0.1:8080/recetas";

    public static RecetaService getRecetaService(){
        return Cliente.getCliente(URL_001).create(RecetaService.class);
    }
}
