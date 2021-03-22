package com.lbnkosi.weatherapp.core.mappers.presenter

import com.lbnkosi.domain.model.weather.DMCity
import com.lbnkosi.domain.model.weather.DMCurrentWeather
import com.lbnkosi.domain.model.weather.DMWeatherForecast
import com.lbnkosi.weatherapp.core.models.presenter.*

internal fun DMWeatherForecast.toPresenter(): UIWeatherForecast {
        return UIWeatherForecast(
            toCity(this.city),
            this.cnt,
            this.cod,
            toWeatherList(this.list),
            this.message
        )
}

fun toCity(city: DMCity) =
    UICity(
        UICoord(city.coord.lat, city.coord.lon),
        city.country,
        city.id,
        city.name,
        city.population,
        city.sunrise,
        city.sunset,
        city.timezone
    )

fun toWeatherList(list: List<DMCurrentWeather>) =
    list.map {
        UICurrentWeather(
            it.base,
            UIClouds(it.clouds.all),
            it.cod,
            UICoord(it.coord.lat, it.coord.lon),
            it.dt,
            it.id,
            UIMain(
                it.main.feels_like,
                it.main.humidity,
                it.main.pressure,
                it.main.temp,
                it.main.temp_max,
                it.main.temp_min
            ),
            it.name,
            UISys(
                it.sys.country,
                it.sys.id,
                it.sys.message,
                it.sys.sunrise,
                it.sys.sunset,
                it.sys.type
            ),
            it.timezone,
            it.visibility,
            it.weather.map { w -> UIWeather(w.description, w.icon, w.id, w.main) },
            UIWind(it.wind.deg, it.wind.speed),
            it.dt_txt,
            it.pop,
            UIRain(it.rain.ThreeH)
        )
    }