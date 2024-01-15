package com.example.aniweather;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    private Button cities_button;
    private TextView main_city_display;
    private String main_city_name;
    private WeatherDataRepository weatherDataRepository;
    private TextView main_temperature_number;
    private TextView main_temperature_unit;
    private TextView single_word_weather;
    private TextView main_max_day_temp;
    private TextView main_min_day_temp;
    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        this.main_city_display = (TextView) findViewById(R.id.main_city_display);
        this.main_city_name = main_city_display.getText().toString();
        this.cities_button = (Button) findViewById(R.id.cities_button);
        weatherDataRepository = WeatherDataRepository.getInstance();

        citiesButtonHandler();


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void citiesButtonHandler(){

        this.cities_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                City city = new City(main_city_name);
                weatherDataRepository.setCity(city);
                weatherDataRepository.setAllTheData();
            }
        });
    }



}
