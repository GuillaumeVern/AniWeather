package com.example.aniweather.model;

import java.util.Date;


public class WeatherAPIData {

    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private Timezone timezone;
    private double elevation;
    private Units current_units;
    private Current current;
    private TimedUnits hourly_units;
    private ArrayList<Hourly> hourly;
    private TimedUnits daily_units;
    private ArrayList<Daily> daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public void setGenerationtime_ms(double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public int getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public void setUtc_offset_seconds(int utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public Units getCurrent_units() {
        return current_units;
    }

    public void setCurrent_units(Units current_units) {
        this.current_units = current_units;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public TimedUnits getHourly_units() {
        return hourly_units;
    }

    public void setHourly_units(TimedUnits hourly_units) {
        this.hourly_units = hourly_units;
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public TimedUnits getDaily_units() {
        return daily_units;
    }

    public void setDaily_units(TimedUnits daily_units) {
        this.daily_units = daily_units;
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Daily> daily) {
        this.daily = daily;
    }


}