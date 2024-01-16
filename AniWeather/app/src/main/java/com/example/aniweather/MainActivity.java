package com.example.aniweather;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aniweather.model.Current;
import com.example.aniweather.model.Daily;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private TextView day_1_max;
    private TextView day_1_min;
    private ImageView day_1_logo;
    private TextView day_1_single_word_weather;
    private TextView day_2_max;
    private TextView day_2_min;
    private ImageView day_2_logo;
    private TextView day_2_single_word_weather;
    private TextView day_3_max;
    private TextView day_3_min;
    private ImageView day_3_logo;
    private TextView day_3_single_word_weather;


    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        this.main_city_display = (TextView) findViewById(R.id.main_city_display);
        this.main_city_name = main_city_display.getText().toString();
        this.cities_button = (Button) findViewById(R.id.cities_button);
        this.main_temperature_number = (TextView) findViewById(R.id.main_temperature_number);
        this.single_word_weather = (TextView) findViewById(R.id.single_word_weather);
        this.main_max_day_temp = (TextView) findViewById(R.id.main_max_day_temp);
        this.main_min_day_temp = (TextView) findViewById(R.id.main_min_day_temp);
        this.day_1_max = (TextView) findViewById(R.id.day_1_max);
        this.day_1_min = (TextView) findViewById(R.id.day_1_min);
        this.day_1_logo = (ImageView) findViewById(R.id.day_1_logo);
        this.day_1_single_word_weather = (TextView) findViewById(R.id.day_1_single_word_weather);
        this.day_2_max = (TextView) findViewById(R.id.day_2_max);
        this.day_2_min = (TextView) findViewById(R.id.day_2_min);
        this.day_2_logo = (ImageView) findViewById(R.id.day_2_logo);
        this.day_2_single_word_weather = (TextView) findViewById(R.id.day_2_single_word_weather);
        this.day_3_max = (TextView) findViewById(R.id.day_3_max);
        this.day_3_min = (TextView) findViewById(R.id.day_3_min);
        this.day_3_logo = (ImageView) findViewById(R.id.day_3_logo);
        this.day_3_single_word_weather = (TextView) findViewById(R.id.day_3_single_word_weather);



        weatherDataRepository = WeatherDataRepository.getInstance();

        citiesButtonHandler();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void citiesButtonHandler(){
        this.cities_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                main_city_name = main_city_display.getText().toString();
                initCurrentData();

            }
        });
    }

    public void initCurrentData(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            City city = new City(main_city_name);
            weatherDataRepository.setCity(city);
            weatherDataRepository.setAllTheData();

            while(weatherDataRepository.isDataReceived() == false){
                // attendre pour la réponse de l'api
            }

            handler.post(() -> {
                // toutes les modifications de l'ui doivent être faites dans le thread principal
                weatherDataRepository.setDataReceived(false);

                Current current = weatherDataRepository.getCurrent();
                Daily today = weatherDataRepository.getToday();

                String temperature_2m = String.valueOf(current.getTemperature_2m());
                main_temperature_number.setText(temperature_2m);

                String weatherVariable = current.getWeatherVariable().libelle;
                single_word_weather.setText(weatherVariable);

                String max_day_temp = String.valueOf(today.getTemperature_2m_max());
                main_max_day_temp.setText(max_day_temp + "°");

                String min_day_temp = String.valueOf(today.getTemperature_2m_min());
                main_min_day_temp.setText(min_day_temp + "°");

                initWeekForecastData();




            });
        });
    }

    public void initWeekForecastData(){
        String day_1_max_temp = String.valueOf(weatherDataRepository.getDaily().get(0).getTemperature_2m_max());
        day_1_max.setText(day_1_max_temp + "°");

        String day_1_min_temp = String.valueOf(weatherDataRepository.getDaily().get(0).getTemperature_2m_min());
        day_1_min.setText(day_1_min_temp + "°");

        String day_1_weatherVariable = weatherDataRepository.getDaily().get(0).getWeatherVariable().libelle;
        day_1_single_word_weather.setText(day_1_weatherVariable);


        String day_2_max_temp = String.valueOf(weatherDataRepository.getDaily().get(1).getTemperature_2m_max());
        day_2_max.setText(day_2_max_temp + "°");

        String day_2_min_temp = String.valueOf(weatherDataRepository.getDaily().get(1).getTemperature_2m_min());
        day_2_min.setText(day_2_min_temp + "°");

        String day_2_weatherVariable = weatherDataRepository.getDaily().get(1).getWeatherVariable().libelle;
        day_2_single_word_weather.setText(day_2_weatherVariable);


        String day_3_max_temp = String.valueOf(weatherDataRepository.getDaily().get(2).getTemperature_2m_max());
        day_3_max.setText(day_3_max_temp + "°");

        String day_3_min_temp = String.valueOf(weatherDataRepository.getDaily().get(2).getTemperature_2m_min());
        day_3_min.setText(day_3_min_temp + "°");

        String day_3_weatherVariable = weatherDataRepository.getDaily().get(2).getWeatherVariable().libelle;
        day_3_single_word_weather.setText(day_3_weatherVariable);


    }



}
