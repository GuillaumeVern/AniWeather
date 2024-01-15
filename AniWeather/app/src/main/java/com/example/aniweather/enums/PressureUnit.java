package com.example.aniweather.enums;

public enum PressureUnit {

    PASCAL("Pa"),
    HECTOPASCAL("HPa");


    public final String libelle;

    private PressureUnit(String libelle){
        this.libelle = libelle;
    }
}
