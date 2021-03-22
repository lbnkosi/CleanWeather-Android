package com.lbnkosi.domain.usecase

import com.lbnkosi.domain.repository.ITWeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val mWeatherRepository: ITWeatherRepository) {

    suspend fun getWeatherForecast(aIsOffline: Boolean, aLat: String, aLon: String, aUnit: String) = mWeatherRepository.getWeatherForecast(aIsOffline, aLat, aLon, aUnit)

}