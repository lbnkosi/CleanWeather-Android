package com.lbnkosi.domain.repository

import com.lbnkosi.domain.model.resource.Resource
import com.lbnkosi.domain.model.weather.WeatherForecast
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {
    suspend fun getWeatherForecast(
        isOffline: Boolean,
        latitude: String,
        longitude: String,
        units: String
    ): Flow<Resource<WeatherForecast>>
}