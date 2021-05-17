package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;

public class Apis {

    public static final String URL_001="http://192.168.153.1:8080/api/v1/";

    public static RecetaService getRecetaService(){
        return Cliente.getCliente(URL_001).create(RecetaService.class);
    }
}
