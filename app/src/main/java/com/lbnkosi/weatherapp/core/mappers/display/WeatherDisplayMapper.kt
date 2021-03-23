package com.lbnkosi.weatherapp.core.mappers.display


import com.lbnkosi.weatherapp.core.extensions.*
import com.lbnkosi.weatherapp.core.models.display.WeatherDisplay
import com.lbnkosi.weatherapp.core.models.presenter.UICurrentWeather
import com.lbnkosi.weatherapp.core.models.presenter.UIWeatherForecast
import java8.util.function.Function

class WeatherDisplayMapper {

    fun toHeaderDisplay(forecast: UIWeatherForecast): WeatherDisplay = mForecastDisplayMapper.apply(forecast)

    fun toWeatherDisplay(currentWeather: UICurrentWeather?): WeatherDisplay = mCurrentWeatherDisplayMapper.apply(currentWeather)

    private val mForecastDisplayMapper = Function<UIWeatherForecast, WeatherDisplay> {
        WeatherDisplay().apply {
            city = it.city.name
            currentTemp = it.list.filter()[0].main.temp.toUnicode()
            maximumTemp = it.list.filter()[0].main.temp_max.toUnicode()
            minimumTemp = it.list.filter()[0].main.temp_min.toUnicode()
            weatherType = it.list.filter()[0].weather.first().main.weatherType()
        }
    }

    private val mCurrentWeatherDisplayMapper = Function<UICurrentWeather, WeatherDisplay> {
        WeatherDisplay().apply {
            city = it.name
            currentTemp = it.main.temp.toUnicode()
            maximumTemp = it.main.temp_max.toUnicode()
            minimumTemp = it.main.temp_min.toUnicode()
            weatherType = it.weather.first().main.weatherType()
            if (it.dt_txt.isNotEmpty()) dayOfWeek = it.dt_txt.toDayOfWeek()
            iconLink = it.weather.icon()
            if (it.dt_txt.isNotEmpty()) date = it.dt_txt.toDate()
        }
    }
}