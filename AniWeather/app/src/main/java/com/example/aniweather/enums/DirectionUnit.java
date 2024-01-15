package com.example.aniweather.enums;

public enum DirectionUnit {
    DEGREES("°");


    public final String libelle;

    private DirectionUnit(String libelle){
        this.libelle = libelle;
    }
}
