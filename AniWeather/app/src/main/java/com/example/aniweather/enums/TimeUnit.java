package com.example.aniweather.enums;

public enum TimeUnit {
    SECOND("s"),
    MINUTE("min"),
    HOUR("h"),
    DAY("d"),
    WEEK("w"),
    MONTH("M"),
    YEAR("Y");


    public final String libelle;

    private TimeUnit(String libelle){
        this.libelle = libelle;
    }

}
