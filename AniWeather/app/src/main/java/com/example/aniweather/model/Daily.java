package com.example.aniweather.model;
import com.example.aniweather.enums.WeatherVariable;

import org.json.JSONObject;

import java.time.*;
import java.util.Iterator;

public class Daily{
    private LocalDate time;
    private WeatherVariable weatherVariable;
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

    public Daily(JSONObject daily_data, int i){
        Iterator<String> keys = daily_data.keys();

        try{

            while(keys.hasNext()) {
                String key = keys.next();
                if (daily_data.get(key) instanceof Object) {
                    switch (key) {
                        case "time":
                            this.setTime(LocalDate.parse(daily_data.getJSONArray(key).getString(i)));
                            break;
                        case "weather_code":
                            this.setWeatherVariable(daily_data.getJSONArray(key).getInt(i));
                            break;
                        case "temperature_2m_max":
                            this.setTemperature_2m_max(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "temperature_2m_min":
                            this.setTemperature_2m_min(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "sunrise":
                            this.setSunrise(LocalDateTime.parse(daily_data.getJSONArray(key).getString(i)));
                            break;
                        case "sunset":
                            this.setSunset(LocalDateTime.parse(daily_data.getJSONArray(key).getString(i)));
                            break;
                        case "daylight_duration":
                            this.setDaylight_duration(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "sunshine_duration":
                            this.setSunshine_duration(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "uv_index_max":
                            this.setUv_index_max(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "precipitation_sum":
                            this.setPrecipitation_sum(daily_data.getJSONArray(key).getInt(i));
                            break;
                        case "precipitation_hours":
                            this.setPrecipitation_hours(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "precipitation_probability_max":
                            this.setPrecipitation_probability_max(daily_data.getJSONArray(key).getInt(i));
                            break;
                        case "wind_speed_10m_max":
                            this.setWind_speed_10m_max(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "wind_gusts_10m_dominant":
                            this.setWind_gusts_10m_dominant(daily_data.getJSONArray(key).getDouble(i));
                            break;
                        case "shortwave_radiation_sum":
                            this.setShortwave_radiation_sum(daily_data.getJSONArray(key).getDouble(i));
                            break;
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public WeatherVariable getWeatherVariable() {
        return weatherVariable;
    }

    public void setWeatherVariable(int weatherVariable) {
        this.weatherVariable = WeatherVariable.getWeatherVariableFromCode(weatherVariable);
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