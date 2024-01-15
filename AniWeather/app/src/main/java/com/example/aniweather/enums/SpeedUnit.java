package com.example.aniweather.enums;

public enum SpeedUnit {
    MS("m/s"),
    KPH("k/h"),
    MPH("m/h");


    public final String libelle;

    private SpeedUnit(String libelle){
        this.libelle = libelle;
    }
}
