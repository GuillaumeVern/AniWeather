package com.example.aniweather;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(City city);

    @Query("SELECT * FROM cities WHERE latitude = :latitude AND longitude = :longitude LIMIT 1")
    City getCityByCoordinates(String latitude, String longitude);

    @Query("SELECT * FROM cities WHERE name = :name LIMIT 1")
    City getCityByName(String name);
}
