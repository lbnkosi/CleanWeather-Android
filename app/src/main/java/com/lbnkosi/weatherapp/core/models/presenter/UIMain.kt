package com.lbnkosi.weatherapp.core.models.presenter

data class UIMain(
    val feels_like: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val temp: Double = 0.0,
    val temp_max: Double = 0.0,
    val temp_min: Double = 0.0
)