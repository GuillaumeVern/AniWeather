package com.example.aniweather;

import static com.github.mikephil.charting.animation.Easing.EaseInCubic;
import static com.github.mikephil.charting.animation.Easing.EaseInOutCubic;
import static com.github.mikephil.charting.animation.Easing.EaseOutCubic;

import android.graphics.Color;
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
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private LineChart chart_24_hours;
    private TextView humidity_value;
    private TextView real_feel_value;
    private TextView uv_value;
    private TextView pressure_value;
    private TextView wind_direction_libelle;
    private TextView wind_speed;
    private TextView sunrise_time;
    private TextView sunset_time;




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
        this.chart_24_hours = (LineChart) findViewById(R.id.chart_24_hours);
        this.humidity_value = (TextView) findViewById(R.id.humidity_value);
        this.real_feel_value = (TextView) findViewById(R.id.real_feel_value);
        this.uv_value = (TextView) findViewById(R.id.uv_value);
        this.pressure_value = (TextView) findViewById(R.id.pressure_value);
        this.wind_direction_libelle = (TextView) findViewById(R.id.wind_direction_libelle);
        this.wind_speed = (TextView) findViewById(R.id.wind_speed);
        this.sunrise_time = (TextView) findViewById(R.id.sunrise_time);
        this.sunset_time = (TextView) findViewById(R.id.sunset_time);





        weatherDataRepository = WeatherDataRepository.getInstance();

        main_city_name = main_city_display.getText().toString();
        initCurrentData();
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

            while(!weatherDataRepository.isDataReceived()){
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
                buildChart();
                initAdditionalInfo();
                initWindInfo();
                initSunInfo();




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

    public void buildChart(){
        List<Entry> entries = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour();

        final ArrayList<String> xLabel = new ArrayList<>();

        int j = 0;
        for(int i = currentHour; i < 24 + currentHour; i+=4){
            xLabel.add(String.valueOf(i % 24) + ":00");
            Entry entry = new Entry(j, (float) weatherDataRepository.getHourly().get(i).getTemperature_2m());
            entries.add(j,entry);
            j++;
        }

        LineDataSet dataSet = new LineDataSet(entries, "Temperature");
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawFilled(true);
        dataSet.setValueTextSize(12f);
        dataSet.setDrawCircles(false);

        dataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return (int) Math.round(value) + "°";
            }
        });
        LineData lineData = new LineData(dataSet);

        chart_24_hours.setData(lineData);
        chart_24_hours.setDrawGridBackground(false);
        chart_24_hours.setDrawBorders(false);
        chart_24_hours.getAxisLeft().setDrawGridLines(false);
        chart_24_hours.getAxisRight().setDrawGridLines(false);
        chart_24_hours.getXAxis().setDrawGridLines(false);
        chart_24_hours.getXAxis().setGranularity(1f);
        chart_24_hours.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        System.out.println("xLabel : " + xLabel);
        chart_24_hours.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xLabel) {
            @Override
            public String getFormattedValue(float value) {
                System.out.println("value : " + value);
                return xLabel.get((int) value);
            }
        });
        chart_24_hours.getXAxis().setDrawAxisLine(false);
        chart_24_hours.getAxisLeft().setDrawAxisLine(false);
        chart_24_hours.getAxisRight().setDrawAxisLine(false);
        chart_24_hours.getLegend().setEnabled(false);
        chart_24_hours.getDescription().setEnabled(false);
        chart_24_hours.getAxisLeft().setDrawLabels(false);
        chart_24_hours.getAxisRight().setDrawLabels(false);
        //chart_24_hours.animateY(1000, EaseInOutCubic);
        chart_24_hours.invalidate();
    }

    public void initAdditionalInfo(){
        String humidity = String.valueOf(weatherDataRepository.getCurrent().getRelative_humidity_2m());
        humidity_value.setText(humidity + "%");

        String real_feel = String.valueOf(weatherDataRepository.getCurrent().getApparent_temperature());
        real_feel_value.setText(real_feel + "°");

        // String uv = String.valueOf(weatherDataRepository.getCurrent().getUv_index_clear_sky());
        // uv_value.setText(uv);
        // cette donnée n'est pas présente dans l'api openmeteo, oopsie doopsie ¯\_(ツ)_/¯

        String pressure = String.valueOf(weatherDataRepository.getCurrent().getPressure_msl());
        pressure_value.setText(pressure + " hPa");
    }

    public void initWindInfo(){
        int wind_direction = weatherDataRepository.getCurrent().getWind_direction_10m();
        String wind_direction_string = "";
        if(wind_direction < 15 || wind_direction > 345){
            wind_direction_string = "North";
        } else if(wind_direction < 75){
            wind_direction_string = "North-East";
        } else if(wind_direction < 105){
            wind_direction_string = "East";
        } else if(wind_direction < 165){
            wind_direction_string = "South-East";
        } else if(wind_direction < 195){
            wind_direction_string = "South";
        } else if(wind_direction < 255){
            wind_direction_string = "South-West";
        } else if(wind_direction < 285){
            wind_direction_string = "West";
        } else if(wind_direction < 345){
            wind_direction_string = "North-West";
        }

        wind_direction_libelle.setText(wind_direction_string);

        String wind_speed_value = String.valueOf(weatherDataRepository.getCurrent().getWind_speed_10m());
        wind_speed.setText(wind_speed_value + " km/h");
    }

    public void initSunInfo(){
        LocalDateTime sunrise_datetime = weatherDataRepository.getToday().getSunrise();
        String sunrise = sunrise_datetime.getHour() + ":" + sunrise_datetime.getMinute();
        sunrise_time.setText(sunrise);

        LocalDateTime sunset_datetime = weatherDataRepository.getToday().getSunset();
        String sunset = sunset_datetime.getHour() + ":" + sunset_datetime.getMinute();
        sunset_time.setText(sunset);
    }

}
