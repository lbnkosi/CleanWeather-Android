package com.lbnkosi.data.model.cache

import com.lbnkosi.data.model.response.WeatherForecastResponse

data class WeatherCache(
    val weatherForecastResponse: WeatherForecastResponse = WeatherForecastResponse()
)
