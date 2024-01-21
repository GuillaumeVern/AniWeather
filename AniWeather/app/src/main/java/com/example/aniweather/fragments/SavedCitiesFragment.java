package com.example.aniweather.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aniweather.AniWeatherApplication;
import com.example.aniweather.CustomAdapter;
import com.example.aniweather.MainActivity;
import com.example.aniweather.RecyclerItemClickListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SavedCitiesFragment extends Fragment {

    Button refresh_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(com.example.aniweather.R.layout.saved_cities_layout, container, false);
        RecyclerView recycler_view = rootView.findViewById(com.example.aniweather.R.id.recycler_view);
        ArrayList<JSONObject> dataSet = getAllCitiesFromFile();
        CustomAdapter customAdapter = new CustomAdapter(dataSet);
        recycler_view.setAdapter(customAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(AniWeatherApplication.getAppContext()));
        this.refresh_button = rootView.findViewById(com.example.aniweather.R.id.refresh_button);

        recycler_view.addOnItemTouchListener(
                new RecyclerItemClickListener(AniWeatherApplication.getAppContext(), recycler_view,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        TextView city_name = view.findViewById(com.example.aniweather.R.id.city_name);
                        ((MainActivity)requireActivity()).setMain_city_name(city_name.getText().toString());
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })

        );

        this.refresh_button.setOnClickListener(v -> {
            ((MainActivity)requireActivity()).refresh();
        });

        return rootView;
    }

    public ArrayList<JSONObject> getAllCitiesFromFile(){
        ArrayList<JSONObject> result = new ArrayList<>();
        File file = new File(AniWeatherApplication.getAppContext().getFilesDir(), "savedCities.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                JSONObject jsonObject = new JSONObject(line);
                result.add(jsonObject);
            }
        } catch(Exception e){
            System.out.println("erreur lors de la lecture de savedCities : " + e.getMessage());
        }
        return result;
    }
}
