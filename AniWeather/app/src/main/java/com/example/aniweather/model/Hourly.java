package com.example.aniweather.model;
import java.time.*;
public class Hourly{

    private LocalDate time;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double dew_poit_2m;
    private double apparent_temperature;
    private int precipitation_probability;
    private int rain;
    private int weather_code;
    private double surface_pressure;
    private int cloud_cover;
    private double wind_speed_10m;
    private double temperature_80m;
    private double uv_index;
    private boolean is_day;
    private double sunshine_duration;

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
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

    public double getDew_poit_2m() {
        return dew_poit_2m;
    }

    public void setDew_poit_2m(double dew_poit_2m) {
        this.dew_poit_2m = dew_poit_2m;
    }

    public double getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public int getPrecipitation_probability() {
        return precipitation_probability;
    }

    public void setPrecipitation_probability(int precipitation_probability) {
        this.precipitation_probability = precipitation_probability;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public int getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }

    public double getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(double surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public int getCloud_cover() {
        return cloud_cover;
    }

    public void setCloud_cover(int cloud_cover) {
        this.cloud_cover = cloud_cover;
    }

    public double getWind_speed_10m() {
        return wind_speed_10m;
    }

    public void setWind_speed_10m(double wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m;
    }

    public double getTemperature_80m() {
        return temperature_80m;
    }

    public void setTemperature_80m(double temperature_80m) {
        this.temperature_80m = temperature_80m;
    }

    public double getUv_index() {
        return uv_index;
    }

    public void setUv_index(double uv_index) {
        this.uv_index = uv_index;
    }

    public boolean isIs_day() {
        return is_day;
    }

    public void setIs_day(boolean is_day) {
        this.is_day = is_day;
    }

    public double getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(double sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }



}
