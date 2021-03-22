package com.lbnkosi.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lbnkosi.data.model.entity.WeatherEntity

@Dao
interface WeatherDao {

    @Query("DELETE FROM WeatherEntity")
    suspend fun deleteWeatherEntity()

    @Query("SELECT * FROM WeatherEntity")
    suspend fun getWeatherEntity(): WeatherEntity

    @Query("SELECT COUNT(*) FROM WeatherEntity")
    suspend fun availableWeather(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherEntity(weatherEntity: WeatherEntity)

}