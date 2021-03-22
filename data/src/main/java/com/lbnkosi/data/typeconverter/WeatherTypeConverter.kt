package com.lbnkosi.data.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lbnkosi.data.model.cache.WeatherCache
import java.lang.reflect.Type

class WeatherTypeConverter {

    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToWeatherList(data: String?): WeatherCache? {
        if (data == null) {
            return WeatherCache()
        }
        val listType: Type = object : TypeToken<WeatherCache>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun weatherListToString(weatherCache: WeatherCache): String? {
        return gson.toJson(weatherCache)
    }
}