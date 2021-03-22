package com.lbnkosi.data.repository

import com.lbnkosi.data.mappers.toDomain
import com.lbnkosi.data.source.WeatherDataSource
import com.lbnkosi.domain.model.resource.DMResource
import com.lbnkosi.domain.model.weather.DMWeatherForecast
import com.lbnkosi.domain.repository.ITWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val mWeatherDataSource: WeatherDataSource) : ITWeatherRepository {

    override suspend fun getWeatherForecast(aIsOffline: Boolean, aLat: String, aLon: String, aUnit: String): Flow<DMResource<DMWeatherForecast>> {
        return mWeatherDataSource.query(aIsOffline, aLat, aLon, aUnit).map { resource ->
            resource.toDomain()
        }
    }
}