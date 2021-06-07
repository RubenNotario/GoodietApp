package com.example.goodiet.Utils;

import com.example.goodiet.Model.Receta;

public class Apis {

    public static final String URL_001="http://192.168.153.1:8080/api/";

    public static RecetaService getRecetaService(){
        return Cliente.getCliente(URL_001).create(RecetaService.class);
    }

    public static CategoriaService getCategoriaService(){
        return Cliente.getCliente(URL_001).create(CategoriaService.class);
    }

    public static RegistroService getRegisterService(){
        return Cliente.getCliente(URL_001).create(RegistroService.class);
    }

    public static LoginService getLoginService(){
        return Cliente.getCliente(URL_001).create(LoginService.class);
    }



}
