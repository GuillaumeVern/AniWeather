package com.example.aniweather;

import android.os.Handler;
import android.os.Looper;

import com.example.aniweather.enums.Timezone;
import com.example.aniweather.model.Current;
import com.example.aniweather.model.Daily;
import com.example.aniweather.model.Hourly;
import com.example.aniweather.model.Units;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Iterator;

/**
 * classe singleton servant a gérer la mise en cache des données de l'api
 */
public class WeatherDataRepository {

    private static WeatherDataRepository WeatherDataRepositoryInstance;


    private City city;

    private String allTheData;

    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private Timezone timezone;
    private double elevation;
    private Units units;
    private Current current;
    private ArrayList<Hourly> hourly;
    private ArrayList<Daily> daily;
    private boolean dataReceived = false;


    private WeatherDataRepository(){};

    public static synchronized WeatherDataRepository getInstance(){
        if(WeatherDataRepositoryInstance == null){
            WeatherDataRepositoryInstance = new WeatherDataRepository();
        }
        return WeatherDataRepositoryInstance;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAllTheData(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(() -> {
            while(!city.isResponseReceived()){
                //thread séparé donc OK de le bloquer
            }

            try{
                URL url = new URL(MessageFormat.format("https://api.open-meteo.com/v1/forecast?latitude={0}&longitude={1}&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,snowfall,weather_code,cloud_cover,pressure_msl,surface_pressure,wind_speed_10m,wind_direction_10m,wind_gusts_10m&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,apparent_temperature,precipitation_probability,rain,weather_code,surface_pressure,cloud_cover,wind_speed_10m,temperature_80m,uv_index,is_day,sunshine_duration&daily=weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,daylight_duration,sunshine_duration,uv_index_max,precipitation_sum,precipitation_hours,precipitation_probability_max,wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant,shortwave_radiation_sum&timezone=Europe%2FBerlin", city.getLatitude(), city.getLongitude()));
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                System.out.println(con.getURL());
                int responseCode = con.getResponseCode();
                System.out.println("all the data GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    this.allTheData = response.toString();
                } else {
                    System.out.println("all the data GET request did not work.");
                }
            } catch(Exception e){
                System.out.println(MessageFormat.format("all the data error: {0} ; {1}", e, e.getMessage()));
            }

            parseToWeatherApiData();

            handler.post(() -> {
            });
        });
    }

    public String getAllTheData() {
        return allTheData;
    }


    public void parseToWeatherApiData(){
        try{
            JSONObject allTheDataJsonObject = new JSONObject(allTheData);
            Iterator<String> keys = allTheDataJsonObject.keys();

            while(keys.hasNext()){
                String key = keys.next();
                System.out.println(key + " : " + allTheDataJsonObject.getString(key));
                if(allTheDataJsonObject.get(key) instanceof JSONObject){
                    switch(key){
                        case "latitude":
                            this.setLatitude(allTheDataJsonObject.getDouble(key));
                            break;
                        case "longitude":
                            this.setLongitude(allTheDataJsonObject.getDouble(key));
                            break;
                        case "utc_offset_seconds":
                            this.setUtc_offset_seconds(allTheDataJsonObject.getInt(key));
                            break;
                        case "timezone":
                            this.setTimezone(allTheDataJsonObject.getString(key));
                            break;
                        case "timezone_abbreviation":
                            // l'abbreviation est directement définie dans l'enum
                            break;
                        case "elevation":
                            this.setElevation(allTheDataJsonObject.getDouble(key));
                            break;
                        case "current_units":
                            break;
                        case "current":
                            this.setCurrent(allTheDataJsonObject.getJSONObject(key));
                            break;
                        case "hourly_units":
                            break;
                        case "hourly":
                            this.setHourly(allTheDataJsonObject.getJSONObject(key));
                            break;
                        case "daily_units":
                            break;
                        case "daily":
                            this.setDaily(allTheDataJsonObject.getJSONObject(key));
                            break;
                        default:
                            break;
                    }
                }
            }
            this.setDataReceived(true);

        } catch(Exception e){
            System.out.println("erreur lors du parsing de AllTheData : " + e.getMessage());
        }
    }



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

    public void setTimezone(String timezone) {
        this.timezone = Timezone.getTimezoneFromString(timezone);
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

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units current_units) {
        this.units = current_units;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(JSONObject current_data) {
            this.current = new Current(current_data);
    }


    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(JSONObject hourlyJSONObject) {
        this.hourly = new ArrayList<Hourly>();
        try{
            for(int i = 0; i < hourlyJSONObject.getJSONArray("time").length(); i++) {
                Hourly hourly = new Hourly(hourlyJSONObject, i);
                this.hourly.add(hourly);
            }

        } catch(Exception e){
            System.out.println("erreur lors du parsing de Hourly : " + e.getMessage());
        }
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(JSONObject dailyJSONObject) {
        this.daily = new ArrayList<Daily>();
        try{
            for(int i = 0; i < dailyJSONObject.getJSONArray("time").length(); i++) {
                Daily daily = new Daily(dailyJSONObject, i);
                this.daily.add(daily);
            }
        } catch(Exception e){
            System.out.println("erreur lors du parsing de Daily : " + e.getMessage());
        }
    }

    public boolean isDataReceived() {
        return dataReceived;
    }

    public void setDataReceived(boolean dataReceived) {
        this.dataReceived = dataReceived;
    }

    public Daily getToday(){
        return this.daily.get(0);
    }



}
