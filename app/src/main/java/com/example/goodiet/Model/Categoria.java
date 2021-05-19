package com.example.goodiet.Model;

public class Categoria {

    public String name;
    public String imageFile;

    public Categoria(String name, String imageFile) {
        this.name = name;
        this.imageFile = imageFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
