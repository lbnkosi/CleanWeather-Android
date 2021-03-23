package com.lbnkosi.domain.model.weather

data class WeatherForecast(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<CurrentWeather> = arrayListOf(),
    val message: Int = 0
)