package com.example.aniweather;

import android.os.Handler;
import android.os.Looper;

import com.example.aniweather.model.WeatherAPIData;

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

    private WeatherAPIData weatherAPIData;


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
            handler.post(() -> {
                parseToWeatherApiData();
            });
        });
    }

    public void parseToWeatherApiData(){
        try{
            JSONObject allTheDataJsonObject = new JSONObject(allTheData);
            Iterator<String> keys = allTheDataJsonObject.keys();

            while(keys.hasNext()){
                String key = keys.next();
                if(allTheDataJsonObject.get(key) instanceof JSONObject){
                    System.out.println("current jsonObject : " + allTheDataJsonObject.get(key));
                }
            }

        } catch(Exception e){
            System.out.println("erreur lors du parsing de AllTheData : " + e.getMessage());
        }
    }




}
