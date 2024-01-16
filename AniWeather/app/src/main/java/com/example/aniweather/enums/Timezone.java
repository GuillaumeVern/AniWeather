package com.example.aniweather.enums;

public enum Timezone {
    EUROPE_BERLIN("Europe/Berlin", "CET");

    public final String libelle;
    public final String abreviation;

    private Timezone(String libelle, String abreviation){

        this.libelle = libelle;
        this.abreviation = abreviation;
    }

    public static Timezone getTimezoneFromString(String timezone){
        Timezone retour = Timezone.EUROPE_BERLIN;
        switch(timezone){
            case "Europe/Berlin":
                retour = Timezone.EUROPE_BERLIN;
                break;
            default:
                retour = Timezone.EUROPE_BERLIN;
                break;
        }
        return retour;
    }
}