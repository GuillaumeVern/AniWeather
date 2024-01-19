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
import java.net.URLEncoder;
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
                URL url = new URL(MessageFormat.format("https://geokeo.com/geocode/v1/search.php?q={0}&api=64850d598ad9483c8b78f2aa166556a7", URLEncoder.encode(cityName)));
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);

                System.out.println("connection:" + con.getHeaderFields());
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
            JSONObject responseJson = new JSONObject(response);
            JSONArray results = responseJson.getJSONArray("results");
            JSONObject result = results.getJSONObject(0);
            JSONObject address_components = result.getJSONObject("address_components");
            JSONObject geometry = result.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");
            this.name = address_components.getString("name");
            this.latitude = location.getString("lat");
            this.longitude = location.getString("lng");
        } catch(JSONException e){
            System.out.println(MessageFormat.format("error: {0} ; {1}", e, e.getMessage()));
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
