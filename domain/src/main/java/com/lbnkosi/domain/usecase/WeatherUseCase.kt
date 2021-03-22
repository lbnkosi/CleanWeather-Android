package com.lbnkosi.domain.usecase

import com.lbnkosi.domain.model.resource.DMResource
import com.lbnkosi.domain.model.weather.DMWeatherForecast
import com.lbnkosi.domain.repository.ITWeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val mWeatherRepository: ITWeatherRepository
) {

    suspend fun getWeatherForecast(
        aIsOffline: Boolean,
        aLat: String,
        aLon: String,
        aUnit: String
    ): Flow<DMResource<DMWeatherForecast>> {
        return mWeatherRepository.getWeatherForecast(aIsOffline, aLat, aLon, aUnit)
    }

}