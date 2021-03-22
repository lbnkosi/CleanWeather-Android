package com.lbnkosi.weatherapp.core.models.presenter

data class UICurrentWeather(
    val base: String = "",
    val clouds: UIClouds = UIClouds(),
    val cod: Int = 0,
    val coord: UICoord = UICoord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: UIMain = UIMain(),
    val name: String = "",
    val sys: UISys = UISys(),
    val timezone: Int = 0,
    val visibility: Int = 0,
    val weather: List<UIWeather> = arrayListOf(),
    val wind: UIWind = UIWind(),
    val dt_txt: String = "",
    val pop: Double = 0.0,
    val rain: UIRain = UIRain(),
)