package com.example.aniweather.model;
import java.time.*;
public class Daily{
    private LocalDate time;
    private int weather_code;
    private double temperature_2m_max;
    private double temperature_2m_min;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private double daylight_duration;
    private double sunshine_duration;
    private double uv_index_max;
    private double precipitation_sum;
    private double precipitation_hours;
    private int precipitation_probability_max;
    private double wind_speed_10m_max;
    private double wind_gusts_10m_dominant;
    private double shortwave_radiation_sum;

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }

    public double getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(double temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public double getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(double temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public LocalDateTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalDateTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalDateTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalDateTime sunset) {
        this.sunset = sunset;
    }

    public double getDaylight_duration() {
        return daylight_duration;
    }

    public void setDaylight_duration(double daylight_duration) {
        this.daylight_duration = daylight_duration;
    }

    public double getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(double sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public double getUv_index_max() {
        return uv_index_max;
    }

    public void setUv_index_max(double uv_index_max) {
        this.uv_index_max = uv_index_max;
    }

    public double getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(int precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public double getShortwave_radiation_sum() {
        return shortwave_radiation_sum;
    }

    public void setShortwave_radiation_sum(double shortwave_radiation_sum) {
        this.shortwave_radiation_sum = shortwave_radiation_sum;
    }

    public double getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(double precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public int getPrecipitation_probability_max() {
        return precipitation_probability_max;
    }

    public void setPrecipitation_probability_max(int probability_max) {
        this.precipitation_probability_max = probability_max;
    }

    public double getWind_speed_10m_max() {
        return wind_speed_10m_max;
    }

    public void setWind_speed_10m_max(double wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max;
    }

    public double getWind_gusts_10m_dominant() {
        return wind_gusts_10m_dominant;
    }

    public void setWind_gusts_10m_dominant(double wind_gusts_10m_dominant) {
        this.wind_gusts_10m_dominant = wind_gusts_10m_dominant;
    }



}