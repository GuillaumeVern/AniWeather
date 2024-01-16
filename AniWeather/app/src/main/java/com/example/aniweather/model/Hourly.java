package com.example.aniweather.model;
import com.example.aniweather.enums.WeatherVariable;

import org.json.JSONObject;

import java.time.*;
import java.util.Iterator;

public class Hourly{

    private LocalDateTime time;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double dew_point_2m;
    private double apparent_temperature;
    private int precipitation_probability;
    private int rain;
    private WeatherVariable weatherVariable;
    private double surface_pressure;
    private int cloud_cover;
    private double wind_speed_10m;
    private double temperature_80m;
    private double uv_index;
    private boolean is_day;
    private double sunshine_duration;

    public Hourly(JSONObject hourly_data, int i){
        Iterator<String> keys = hourly_data.keys();

        try{
            while (keys.hasNext()) {
                String key = keys.next();
                if (hourly_data.get(key) instanceof Object) {
                    switch (key) {
                        case "time":
                            this.setTime(LocalDateTime.parse(hourly_data.getJSONArray(key).getString(i)));
                            break;
                        case "temperature_2m":
                            this.setTemperature_2m(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "relative_humidity_2m":
                            this.setRelative_humidity_2m(hourly_data.getJSONArray(key).getInt(i));
                            break;
                        case "dew_point_2m":
                            this.setDew_point_2m(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "apparent_temperature":
                            this.setApparent_temperature(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "precipitation_probability":
                            this.setPrecipitation_probability(hourly_data.getJSONArray(key).getInt(i));
                            break;
                        case "rain":
                            this.setRain(hourly_data.getJSONArray(key).getInt(i));
                            break;
                        case "weather_code":
                            this.setWeatherVariable(hourly_data.getJSONArray(key).getInt(i));
                            break;
                        case "surface_pressure":
                            this.setSurface_pressure(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "cloud_cover":
                            this.setCloud_cover(hourly_data.getJSONArray(key).getInt(i));
                            break;
                        case "wind_speed_10m":
                            this.setWind_speed_10m(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "temperature_80m":
                            this.setTemperature_80m(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "uv_index":
                            this.setUv_index(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                        case "is_day":
                            this.setIs_day(hourly_data.getJSONArray(key).getInt(i) <= 0 ? false : true);
                            break;
                        case "sunshine_duration":
                            this.setSunshine_duration(hourly_data.getJSONArray(key).getDouble(i));
                            break;
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    public double getDew_point_2m() {
        return dew_point_2m;
    }

    public void setDew_point_2m(double dew_point_2m) {
        this.dew_point_2m = dew_point_2m;
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

    public WeatherVariable getWeatherVariable() {
        return weatherVariable;
    }

    public void setWeatherVariable(int weatherVariable) {
        this.weatherVariable = WeatherVariable.getWeatherVariableFromCode(weatherVariable);
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
