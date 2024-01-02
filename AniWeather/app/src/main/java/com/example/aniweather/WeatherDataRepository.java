package com.example.aniweather;

import java.net.*;

/**
 * classe singleton servant a gérer la mise en cache des données de l'api
 */
public class WeatherDataRepository {

    private static WeatherDataRepository WeatherDataRepositoryInstance;


    private City city;


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




}
