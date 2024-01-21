package com.example.aniweather;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {City.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract CityDao cityDao();
}
