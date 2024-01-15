package com.example.aniweather.enums;

public enum DistanceUnit {

    MILIMETER("mm"),
    CENTIMETER("cm"),
    METER("m"),
    KILOMETER("km");


    public final String libelle;

    private DistanceUnit(String libelle){
        this.libelle = libelle;
    }
}
