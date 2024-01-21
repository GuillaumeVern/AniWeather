package com.example.aniweather;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.github.mikephil.charting.BuildConfig;

public class AniWeatherApplication extends Application {

    private static Context context;

    public AniWeatherApplication(){
        if(BuildConfig.DEBUG)
            StrictMode.enableDefaults();
    }

    public void onCreate() {
        super.onCreate();
        AniWeatherApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return AniWeatherApplication.context;
    }
}