package com.lbnkosi.data.mappers

import com.lbnkosi.data.enums.DTResourceStatus.SUCCESS
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.model.resource.DTResource
import com.lbnkosi.data.model.response.City
import com.lbnkosi.data.model.response.CurrentWeatherResponse
import com.lbnkosi.data.model.response.WeatherForecastResponse
import com.lbnkosi.domain.model.resource.DMResource
import com.lbnkosi.domain.model.weather.*

internal fun DTResource<WeatherEntity>.toDomain(): DMResource<DMWeatherForecast> {
    return if (this.DTResourceStatus == SUCCESS) {
        DMResource.success(responseToDomainWeather(this.data!!.weatherCache.weatherForecastResponse))
    } else {
        DMResource.error(this.message!!, null)
    }
}

fun responseToDomainWeather(response: WeatherForecastResponse): DMWeatherForecast {
    return DMWeatherForecast(
        toCity(response.city),
        response.cnt,
        response.cod,
        toWeatherList(response.list),
        response.message
    )
}

fun toCity(city: City): DMCity {
    return DMCity(
        DMCoord(city.coord.lat, city.coord.lon),
        city.country,
        city.id,
        city.name,
        city.population,
        city.sunrise,
        city.sunset,
        city.timezone
    )
}

fun toWeatherList(list: List<CurrentWeatherResponse>): List<DMCurrentWeather> {
    return list.map {
        DMCurrentWeather(
            it.base,
            DMClouds(it.clouds.all),
            it.cod,
            DMCoord(it.coord.lat, it.coord.lon),
            it.dt,
            it.id,
            DMMain(it.main.feels_like, it.main.humidity, it.main.pressure, it.main.temp, it.main.temp_max, it.main.temp_min),
            it.name,
            DMSys(it.sys.country, it.sys.id, it.sys.message, it.sys.sunrise, it.sys.sunset, it.sys.type),
            it.timezone,
            it.visibility,
            it.weather.map { w -> DMWeather(w.description, w.icon, w.id, w.main) },
            DMWind(it.wind.deg, it.wind.speed),
            it.dt_txt,
            it.pop,
            DMRain(it.rain.ThreeH)
        )
    }
}

fun WeatherCache.toEntity(): WeatherEntity {
    return WeatherEntity(0, this.copy())
}

