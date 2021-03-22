package com.lbnkosi.domain.repository

import com.lbnkosi.domain.model.resource.DMResource
import com.lbnkosi.domain.model.weather.DMWeatherForecast
import kotlinx.coroutines.flow.Flow

interface ITWeatherRepository {
    suspend fun getWeatherForecast(aIsOffline: Boolean, aLat: String, aLon: String, aUnit: String): Flow<DMResource<DMWeatherForecast>>
}