package com.example.aniweather.model;

public class Current {

    private String time;
    private int interval;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double apparent_temperature;
    private boolean is_day;
    private double precipitation;
    private double rain;
    private double showers;
    private double snowfall;
    private double weather_code;
    private int cloud_cover;
    private double pressure_msl;
    private double surface_pressure;
    private double wind_speed_10m;
    private int wind_direction_10m;
    private double wind_gusts_10m;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public double getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public int getRelative_humidity_2m() {
        return relative_humidity_2m;
    }

    public void setRelative_humidity_2m(int relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }

    public double getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public boolean isIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        switch(is_day){
            case 0:
                this.is_day = false;
                break;
            case 1:
                this.is_day = true;
        }
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getShowers() {
        return showers;
    }

    public void setShowers(double showers) {
        this.showers = showers;
    }

    public double getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(double snowfall) {
        this.snowfall = snowfall;
    }

    public double getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(double weather_code) {
        this.weather_code = weather_code;
    }

    public int getCloud_cover() {
        return cloud_cover;
    }

    public void setCloud_cover(int cloud_cover) {
        this.cloud_cover = cloud_cover;
    }

    public double getPressure_msl() {
        return pressure_msl;
    }

    public void setPressure_msl(double pressure_msl) {
        this.pressure_msl = pressure_msl;
    }

    public double getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(double surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public double getWind_speed_10m() {
        return wind_speed_10m;
    }

    public void setWind_speed_10m(double wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m;
    }

    public int getWind_direction_10m() {
        return wind_direction_10m;
    }

    public void setWind_direction_10m(int wind_direction_10m) {
        this.wind_direction_10m = wind_direction_10m;
    }

    public double getWind_gusts_10m() {
        return wind_gusts_10m;
    }

    public void setWind_gusts_10m(double wind_gusts_10m) {
        this.wind_gusts_10m = wind_gusts_10m;
    }



}
