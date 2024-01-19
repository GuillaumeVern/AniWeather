package com.example.aniweather.model;

import com.example.aniweather.enums.WeatherVariable;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Current {

    private LocalDateTime time;
    private int interval;
    private double temperature_2m;
    private int relative_humidity_2m;
    private double apparent_temperature;
    private boolean is_day;
    private double precipitation;
    private double rain;
    private double showers;
    private double snowfall;
    private WeatherVariable weatherVariable;
    private int cloud_cover;
    private double pressure_msl;
    private double surface_pressure;
    private double wind_speed_10m;
    private int wind_direction_10m;
    private double wind_gusts_10m;



    public Current(JSONObject current_data){
        Iterator<String> keys = current_data.keys();

        try{
            while(keys.hasNext()){
                String key = keys.next();
                if(current_data.get(key) instanceof Object){
                    switch(key){
                        case "time":
                            this.setTime(current_data.getString(key));
                            break;
                        case "interval":
                            this.setInterval(current_data.getInt(key));
                            break;
                        case "temperature_2m":
                            this.setTemperature_2m(current_data.getDouble(key));
                            break;
                        case "relative_humidity_2m":
                            this.setRelative_humidity_2m(current_data.getInt(key));
                            break;
                        case "apparent_temperature":
                            this.setApparent_temperature(current_data.getDouble(key));
                            break;
                        case "is_day":
                            this.setIs_day((current_data.getInt(key)));
                            break;
                        case "precipitation":
                            this.setPrecipitation(current_data.getDouble(key));
                            break;
                        case "rain":
                            this.setRain(current_data.getDouble(key));
                            break;
                        case "showers":
                            this.setShowers(current_data.getDouble(key));
                            break;
                        case "snowfall":
                            this.setSnowfall(current_data.getDouble(key));
                            break;
                        case "weather_code":
                            this.setWeatherVariable(current_data.getInt(key));
                            break;
                        case "cloud_cover":
                            this.setCloud_cover(current_data.getInt(key));
                            break;
                        case "pressure_msl":
                            this.setPressure_msl(current_data.getDouble(key));
                            break;
                        case "surface_pressure":
                            this.setSurface_pressure(current_data.getDouble(key));
                            break;
                        case "wind_speed_10m":
                            this.setWind_speed_10m(current_data.getDouble(key));
                            break;
                        case "wind_direction_10m":
                            this.setWind_direction_10m(current_data.getInt(key));
                            break;
                        case "wind_gusts_10m":
                            this.setWind_gusts_10m(current_data.getDouble(key));
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch(Exception e){
            System.out.println("erreur lors du parsing de current : " + e.getMessage());
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        this.time = localDateTime;
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

    public WeatherVariable getWeatherVariable() {
        return weatherVariable;
    }

    public void setWeatherVariable(int weatherVariable) {
        this.weatherVariable = WeatherVariable.getWeatherVariableFromCode(weatherVariable);
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
