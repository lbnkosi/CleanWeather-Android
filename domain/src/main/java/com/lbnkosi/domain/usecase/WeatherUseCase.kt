package com.lbnkosi.domain.usecase

import com.lbnkosi.domain.model.resource.Resource
import com.lbnkosi.domain.model.weather.WeatherForecast
import com.lbnkosi.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val mWeatherRepository: IWeatherRepository
) {
    suspend fun getWeatherForecast(
        isOffline: Boolean,
        latitude: String,
        longitude: String,
        units: String
    ): Flow<Resource<WeatherForecast>> {
        return mWeatherRepository.getWeatherForecast(isOffline, latitude, longitude, units)
    }
}