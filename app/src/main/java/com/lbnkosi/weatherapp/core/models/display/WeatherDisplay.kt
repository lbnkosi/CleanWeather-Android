package com.lbnkosi.weatherapp.core.models.display

import com.lbnkosi.weatherapp.core.enums.WeatherTypeEnum

data class WeatherDisplay(
    var weatherType: WeatherTypeEnum = WeatherTypeEnum.UNKNOWN,
    var minimumTemp: String = "",
    var maximumTemp: String = "",
    var currentTemp: String = "",
    var dayOfWeek: String = "",
    var iconLink: String = "",
    var city: String = "",
    var date: String = ""
)