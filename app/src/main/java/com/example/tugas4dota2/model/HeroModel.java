package com.example.tugas4dota2.model;

public class HeroModel {
    private String image,name,role, lore;

    public HeroModel(String image, String name, String role, String lore) {
        this.image   = image;
        this.name    = name;
        this.role    = role;
        this.lore = lore;
    }

    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public String getLore() {
        return lore;
    }
}
