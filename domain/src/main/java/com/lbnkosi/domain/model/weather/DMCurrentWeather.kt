package com.lbnkosi.domain.model.weather

data class DMCurrentWeather(
    val base: String = "",
    val clouds: DMClouds = DMClouds(),
    val cod: Int = 0,
    val coord: DMCoord = DMCoord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: DMMain = DMMain(),
    val name: String = "",
    val sys: DMSys = DMSys(),
    val timezone: Int = 0,
    val visibility: Int= 0,
    val weather: List<DMWeather> = arrayListOf(),
    val wind: DMWind = DMWind(),
    val dt_txt: String = "",
    val pop: Double = 0.0,
    val rain: DMRain = DMRain(),
)