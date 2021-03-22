package com.dvt.weatherapp.core.models.display

import com.lbnkosi.weatherapp.core.enums.WeatherTypeEnum

data class WeatherDisplay(
    var weatherType: WeatherTypeEnum = WeatherTypeEnum.UNKNOWN,
    var minimumTemp: String = "",
    var maximumTemp: String = "",
    var currentTemp: String = "",
    var dayOfWeek: String = "",
    var city: String = ""
)