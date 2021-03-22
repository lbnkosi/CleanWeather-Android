package com.lbnkosi.domain.model.weather

data class DMWeatherForecast(
    val city: DMCity = DMCity(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<DMCurrentWeather> = arrayListOf(),
    val message: Int = 0
)