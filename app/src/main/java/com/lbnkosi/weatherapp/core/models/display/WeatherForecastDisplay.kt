package com.dvt.weatherapp.core.models.display

import com.lbnkosi.weatherapp.core.enums.WeatherTypeEnum

data class WeatherForecastDisplay(
    var weatherType: WeatherTypeEnum? = null,
    var currentTemp: String = "",
    var calenderDay: String = ""
)