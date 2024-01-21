package com.example.aniweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aniweather.enums.WeatherVariable;

import org.json.JSONObject;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final ArrayList<JSONObject> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView city_name;
        private final TextView temperature;
        private final TextView single_word_weather_recycler;
        private final TextView min_temperature;
        private final TextView max_temperature;
        private final ImageView logo;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            city_name = (TextView) view.findViewById(R.id.city_name);
            temperature = (TextView) view.findViewById(R.id.temperature);
            single_word_weather_recycler = (TextView) view.findViewById(R.id.single_word_weather_recycler);
            min_temperature = (TextView) view.findViewById(R.id.min_temperature);
            max_temperature = (TextView) view.findViewById(R.id.max_temperature);
            logo = (ImageView) view.findViewById(R.id.logo);


        }

        public ImageView getLogo() {
            return logo;
        }

        public TextView getCityName() {
            return city_name;
        }

        public TextView getTemperature() {
            return temperature;
        }

        public TextView getSingleWordWeather() {
            return single_word_weather_recycler;
        }

        public TextView getMinTemperature() {
            return min_temperature;
        }

        public TextView getMaxTemperature() {
            return max_temperature;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(ArrayList<JSONObject> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        try{
            String city_name = localDataSet.get(position).getString("city_name");
            String temperature = localDataSet.get(position).getJSONObject("current").getString("temperature_2m");
            String single_word_weather = WeatherVariable.getWeatherVariableFromCode(localDataSet.get(position).getJSONObject("current").getInt("weather_code")).libelle;
            String min_temperature = localDataSet.get(position).getJSONObject("daily").getJSONArray("temperature_2m_min").getString(0);
            String max_temperature = localDataSet.get(position).getJSONObject("daily").getJSONArray("temperature_2m_max").getString(0);
            String logo = WeatherVariable.getWeatherVariableFromCode(localDataSet.get(position).getJSONObject("current").getInt("weather_code")).path;

            viewHolder.getLogo().setImageResource(AniWeatherApplication.getAppContext().getResources().getIdentifier(logo, "drawable", AniWeatherApplication.getAppContext().getPackageName()));
            viewHolder.getCityName().setText(city_name);
            viewHolder.getTemperature().setText(temperature + "°");
            viewHolder.getSingleWordWeather().setText(single_word_weather);
            viewHolder.getMinTemperature().setText(min_temperature + "°");
            viewHolder.getMaxTemperature().setText(max_temperature + "°");

        } catch(Exception e){
            System.out.println("erreur lors de la lecture de savedCities : " + e.getMessage());
        }

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
