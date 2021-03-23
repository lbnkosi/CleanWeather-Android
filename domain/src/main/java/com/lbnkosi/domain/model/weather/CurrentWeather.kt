package com.lbnkosi.domain.model.weather

data class CurrentWeather(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val coord: Coord = Coord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: Main = Main(),
    val name: String = "",
    val sys: Sys = Sys(),
    val timezone: Int = 0,
    val visibility: Int= 0,
    val weather: List<Weather> = arrayListOf(),
    val wind: Wind = Wind(),
    val dt_txt: String = "",
    val pop: Double = 0.0,
    val rain: Rain = Rain(),
)