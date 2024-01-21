package com.example.aniweather.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.aniweather.AniWeatherApplication;
import com.example.aniweather.MainActivity;
import com.example.aniweather.R;

public class SettingsFragment extends Fragment {

    private Switch metric_units_switch;
    private Switch i_like_doughnut_switch;
    private Button apply_settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.settings_layout, container, false);
        this.metric_units_switch = rootView.findViewById(R.id.metric_units_switch);
        this.apply_settings = (Button) rootView.findViewById(R.id.apply_settings);
        SharedPreferences prefs = AniWeatherApplication.getAppContext().getSharedPreferences("prefs", MODE_PRIVATE);
        if (prefs.getString("metric_units", "metric").equals("metric")) {
            this.getMetric_units_switch().setChecked(true);
        } else {
            this.getMetric_units_switch().setChecked(false);
        }
        this.getMetric_units_switch().setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            if (isChecked) {
                editor.putString("metric_units", "metric");
            } else {
                editor.putString("metric_units", "imperial");
            }
            editor.apply();
        });

        this.i_like_doughnut_switch = rootView.findViewById(R.id.i_like_doughnuts_switch);
        if (prefs.getBoolean("i_like_doughnuts", false)) {
            this.i_like_doughnut_switch.setChecked(true);
        } else {
            this.i_like_doughnut_switch.setChecked(false);
        }
        this.i_like_doughnut_switch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            if (isChecked) {
                editor.putBoolean("i_like_doughnuts", true);
            } else {
                editor.putBoolean("i_like_doughnuts", false);
            }
            editor.apply();
        });

        // utilisation d'une intent parce que c'est plus simple et parce que j'en ai pas utilisé dans toute l'appli
        this.apply_settings.setOnClickListener(v -> {
            Intent i = new Intent(AniWeatherApplication.getAppContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        });
        return rootView;
    }

    public Switch getMetric_units_switch() {
        return metric_units_switch;
    }

    public void setMetric_units_switch(Switch metric_units_switch) {
        this.metric_units_switch = metric_units_switch;
    }

}