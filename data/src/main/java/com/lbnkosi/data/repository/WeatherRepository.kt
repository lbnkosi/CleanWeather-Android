package com.lbnkosi.data.repository

import com.lbnkosi.data.mappers.toDomain
import com.lbnkosi.data.source.WeatherDataSource
import com.lbnkosi.domain.model.resource.Resource
import com.lbnkosi.domain.model.weather.WeatherForecast
import com.lbnkosi.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val dataSource: WeatherDataSource
) : IWeatherRepository {
    override suspend fun getWeatherForecast(
        isOffline: Boolean,
        latitude: String,
        longitude: String,
        units: String
    ): Flow<Resource<WeatherForecast>> {
        return dataSource.query(isOffline, latitude, longitude, units).map { resource ->
            resource.toDomain()
        }
    }
}