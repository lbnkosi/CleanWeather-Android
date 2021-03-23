package com.lbnkosi.weatherapp.core.mappers.presenter

import com.lbnkosi.data.utils.WeatherForecastResource
import com.lbnkosi.domain.enums.ResourceStatus
import com.lbnkosi.domain.model.weather.City
import com.lbnkosi.domain.model.weather.CurrentWeather
import com.lbnkosi.weatherapp.core.models.presenter.*
import com.lbnkosi.weatherapp.core.models.resource.Resource

internal fun WeatherForecastResource.toPresenter(): Resource<WeatherForecast> {
    return when (this.resourceStatus) {
        ResourceStatus.SUCCESS -> Resource.success(this.data!!.toPresenter())
        else -> Resource.error(this.message!!, null)
    }
}

internal fun com.lbnkosi.domain.model.weather.WeatherForecast.toPresenter(): WeatherForecast {
    return WeatherForecast(
        toCityPresenter(this.city),
        this.cnt,
        this.cod,
        toPresenterWeatherList(this.list),
        this.message
    )
}

internal fun toCityPresenter(city: City): com.lbnkosi.weatherapp.core.models.presenter.City {
    return City(
        Coord(city.coord.lat, city.coord.lon),
        city.country,
        city.id,
        city.name,
        city.population,
        city.sunrise,
        city.sunset,
        city.timezone
    )
}

internal fun toPresenterWeatherList(list: List<CurrentWeather>): List<com.lbnkosi.weatherapp.core.models.presenter.CurrentWeather> {
    return list.map {
        CurrentWeather(
            it.base,
            Clouds(it.clouds.all),
            it.cod,
            Coord(it.coord.lat, it.coord.lon),
            it.dt,
            it.id,
            Main(it.main.feels_like, it.main.humidity, it.main.pressure, it.main.temp, it.main.temp_max, it.main.temp_min),
            it.name,
            Sys(it.sys.country, it.sys.id, it.sys.message, it.sys.sunrise, it.sys.sunset, it.sys.type),
            it.timezone,
            it.visibility,
            it.weather.map { w -> Weather(w.description, w.icon, w.id, w.main) },
            Wind(it.wind.deg, it.wind.speed),
            it.dt_txt,
            it.pop,
            Rain(it.rain.ThreeH)
        )
    }
}