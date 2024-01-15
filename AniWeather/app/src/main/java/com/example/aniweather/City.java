package com.example.aniweather;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class City {
    private String name;
    private String latitude;
    private String longitude;

    private boolean responseReceived;
    public City(String cityName){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        this.responseReceived = false;
        executor.execute(() -> {
            try{
                URL url = new URL(MessageFormat.format("https://geo.api.gouv.fr/communes?nom={0}&boost=population&limit=1&fields=centre", cityName));
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                System.out.println(con.getURL());
                int responseCode = con.getResponseCode();
                System.out.println("city name GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // print result
                    System.out.println("response:" + response);
                    parseResponseToObject(response.toString());
                } else {
                    System.out.println("city name GET request did not work.");
                }
            } catch(Exception e){
                System.out.println(MessageFormat.format("error: {0} ; {1}", e, e.getMessage()));
            }

            this.responseReceived = true;

            handler.post(() -> {
            });
        });

    }

    private void parseResponseToObject(String response){
        try{
            JSONArray jsonArray = new JSONArray(response);
            JSONArray coordinates = jsonArray.getJSONObject(0).getJSONObject("centre").getJSONArray("coordinates");

            this.longitude = coordinates.getString(0);
            this.latitude = coordinates.getString(1);
        } catch(Exception e){
            System.out.println("erreur lors du parsing des coordonnées : " + e.getMessage());
        }

    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public boolean isResponseReceived() {
        return responseReceived;
    }

    public void setResponseReceived(boolean responseReceived) {
        this.responseReceived = responseReceived;
    }
}
