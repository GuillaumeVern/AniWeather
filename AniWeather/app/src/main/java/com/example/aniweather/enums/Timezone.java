package com.example.aniweather.enums;

public enum Timezone {
    EUROPE_BERLIN("Europe/Berlin", "CET");

    public final String libelle;
    public final String abreviation;

    private Timezone(String libelle, String abreviation){

        this.libelle = libelle;
        this.abreviation = abreviation;
    }
}