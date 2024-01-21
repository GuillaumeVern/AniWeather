package com.example.aniweather.enums;

public enum TemperatureUnit {
    CELSIUS("°C"),
    FAHRENHEIT("°F"),
    KELVIN("°K");

    public final String libelle;

    private TemperatureUnit(String libelle){
        this.libelle = libelle;
    }
}
