package com.example.aniweather.enums;

public enum WeatherVariable {
    CLEAR_SKY("Clear sky", 0, "sun_f"),
    MAINLY_CLEAR_("Mainly clear", 1, "cloud_sun_f"),
    PARTLY_CLOUDY("Partly cloudy", 2, "cloud_sun_f"),
    OVERCAST("Overcast", 3, "cloud_basic_f"),
    FOG("Fog", 45, "cloud_fog_f"),
    DEPOSITING_RIME_FOG("Depositing rime fog", 48, "cloud_fog_f"),
    DRIZZLE_LIGHT("Light drizzle", 51, "cloud_rain_f"),
    DRIZZLE_MODERATE("Moderate drizzle", 53, "cloud_rain_f"),
    DRIZZLE_HEAVY("Heavy drizzle", 55, "cloud_rain_f"),
    DRIZZLE_FREEZING_LIGHT("Light freezing drizzle", 56, "cloud_rain_f"),
    DRIZZLE_FREEZING_HEAVY("Heavy freezing drizzle", 57, "cloud_rain_f"),
    RAIN_LIGHT("Slight rain", 61, "cloud_rain_f"),
    RAIN_MODERATE("Moderate rain", 63, "cloud_rain_f"),
    RAIN_HEAVY("Heavy rain", 65, "cloud_rain_f"),
    RAIN_FREEZING_LIGHT("Light freezing rain", 66, "cloud_rain_f"),
    RAIN_FREEZING_HEAVY("Heavy freezing rain", 67, "cloud_rain_f"),
    SNOW_LIGHT("Light snow fall", 71, "cloud_snow_f"),
    SNOW_MODERATE("Moderate snow fall", 73, "cloud_snow_f"),
    SNOW_HEAVY("Heavy snow fall", 75, "cloud_snow_f"),
    SNOW_GRAINS("Snow grains", 77, "snow_f"),
    RAIN_SHOWER_LIGHT("Light rain showers", 80, "cloud_rain_f"),
    RAIN_SHOWER_MODERATE("Moderate rain showers", 81, "cloud_rain_f"),
    RAIN_SHOWER_HEAVY("Violent rain showers", 82, "cloud_rain_f"),
    SNOW_SHOWER_LIGHT("Light snow showers", 85, "cloud_snow_f"),
    SNOW_SHOWER_HEAVY("Heavy snow showers", 86, "cloud_snow_f"),
    THUNDERSTORM("Thunderstorm", 95, "cloud_lightning_f"),
    THUNDERSTORM_HAIL_LIGHT("Thunderstorm with light hail", 96, "cloud_lightning_f"),
    THUNDERSTORM_HAIL_HEAVY("Thunderstorm with heavy hail", 99, "cloud_lightning_f");

    public final String libelle;
    public final int code;
    public final String path;

    // public final String path;
    // path des images seront sotckés dans l'enum

    private WeatherVariable(String libelle, int code, String path){
        this.libelle = libelle;
        this.code = code;
        this.path = path;
    }

    public static WeatherVariable getWeatherVariableFromCode(int code){
        WeatherVariable retour = WeatherVariable.CLEAR_SKY;
        switch(code) {
            case 0:
                retour = WeatherVariable.CLEAR_SKY;
                break;
            case 1:
                retour = WeatherVariable.MAINLY_CLEAR_;
                break;
            case 2:
                retour = WeatherVariable.PARTLY_CLOUDY;
                break;
            case 3:
                retour = WeatherVariable.OVERCAST;
                break;
            case 45:
                retour = WeatherVariable.FOG;
                break;
            case 48:
                retour = WeatherVariable.DEPOSITING_RIME_FOG;
                break;
            case 51:
                retour = WeatherVariable.DRIZZLE_LIGHT;
                break;
            case 53:
                retour = WeatherVariable.DRIZZLE_MODERATE;
                break;
            case 55:
                retour = WeatherVariable.DRIZZLE_HEAVY;
                break;
            case 56:
                retour = WeatherVariable.DRIZZLE_FREEZING_LIGHT;
                break;
            case 57:
                retour = WeatherVariable.DRIZZLE_FREEZING_HEAVY;
                break;
            case 61:
                retour = WeatherVariable.RAIN_LIGHT;
                break;
            case 63:
                retour = WeatherVariable.RAIN_MODERATE;
                break;
            case 65:
                retour = WeatherVariable.RAIN_HEAVY;
                break;
            case 66:
                retour = WeatherVariable.RAIN_FREEZING_LIGHT;
                break;
            case 67:
                retour = WeatherVariable.RAIN_FREEZING_HEAVY;
                break;
            case 71:
                retour = WeatherVariable.SNOW_LIGHT;
                break;
            case 73:
                retour = WeatherVariable.SNOW_MODERATE;
                break;
            case 75:
                retour = WeatherVariable.SNOW_HEAVY;
                break;
            case 77:
                retour = WeatherVariable.SNOW_GRAINS;
                break;
            case 80:
                retour = WeatherVariable.RAIN_SHOWER_LIGHT;
                break;
            case 81:
                retour = WeatherVariable.RAIN_SHOWER_MODERATE;
                break;
            case 82:
                retour = WeatherVariable.RAIN_SHOWER_HEAVY;
                break;
            case 85:
                retour = WeatherVariable.SNOW_SHOWER_LIGHT;
                break;
            case 86:
                retour = WeatherVariable.SNOW_SHOWER_HEAVY;
                break;
            case 95:
                retour = WeatherVariable.THUNDERSTORM;
                break;
            case 96:
                retour = WeatherVariable.THUNDERSTORM_HAIL_LIGHT;
                break;
            case 99:
                retour = WeatherVariable.THUNDERSTORM_HAIL_HEAVY;
                break;
            default:
                retour = WeatherVariable.CLEAR_SKY;
                break;
        }
        return retour;

    }



}
