package com.lbnkosi.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.typeconverter.WeatherTypeConverter

@Entity(tableName = "WeatherEntity")
class WeatherEntity(

    @PrimaryKey(autoGenerate = true) var key: Int = 0,

    @ColumnInfo(name = "weatherForecast")
    @TypeConverters(WeatherTypeConverter::class)
    var weatherCache: WeatherCache = WeatherCache(),

)