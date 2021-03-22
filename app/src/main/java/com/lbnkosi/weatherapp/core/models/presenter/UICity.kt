package com.lbnkosi.weatherapp.core.models.presenter

data class UICity(
    val coord: UICoord = UICoord(),
    val country: String = "",
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val timezone: Int = 0
)