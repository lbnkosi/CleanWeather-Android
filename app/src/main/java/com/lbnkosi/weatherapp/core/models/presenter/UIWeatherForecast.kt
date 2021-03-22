package com.lbnkosi.weatherapp.core.models.presenter

data class UIWeatherForecast(
    val city: UICity = UICity(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<UICurrentWeather> = arrayListOf(),
    val message: Int = 0
)