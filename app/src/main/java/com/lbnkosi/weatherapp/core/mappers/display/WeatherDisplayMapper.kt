package com.lbnkosi.weatherapp.core.mappers.display


import com.lbnkosi.weatherapp.core.extensions.icon
import com.lbnkosi.weatherapp.core.models.display.WeatherDisplay
import com.lbnkosi.weatherapp.core.extensions.toDayOfWeek
import com.lbnkosi.weatherapp.core.extensions.toUnicode
import com.lbnkosi.weatherapp.core.extensions.weatherType
import com.lbnkosi.weatherapp.core.models.presenter.UICurrentWeather
import java8.util.function.Function

class WeatherDisplayMapper {

    fun toCurrentWeatherDisplay(currentWeather: UICurrentWeather?): WeatherDisplay = mCurrentWeatherDisplayMapper.apply(currentWeather)

    private val mCurrentWeatherDisplayMapper = Function<UICurrentWeather, WeatherDisplay> {
        WeatherDisplay().apply {
            city = it.name
            currentTemp = it.main.temp.toUnicode()
            maximumTemp = it.main.temp_max.toUnicode()
            minimumTemp = it.main.temp_min.toUnicode()
            weatherType = it.weather.first().main.weatherType()
            if (it.dt_txt.isNotEmpty()) dayOfWeek = it.dt_txt.toDayOfWeek()
            iconLink = it.weather.icon()
        }
    }
}