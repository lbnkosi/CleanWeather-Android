package com.lbnkosi.data.mappers

import com.lbnkosi.data.enums.ResourceStatus
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.model.resource.Resource
import com.lbnkosi.data.model.response.City
import com.lbnkosi.data.model.response.CurrentWeatherResponse
import com.lbnkosi.data.model.response.WeatherForecastResponse
import com.lbnkosi.data.utils.DomainResource
import com.lbnkosi.data.utils.WeatherForecastResource
import com.lbnkosi.domain.model.weather.*

internal fun Resource<WeatherEntity>.toDomain(): WeatherForecastResource {
    return if (this.resourceStatus == ResourceStatus.SUCCESS) {
        DomainResource.success(toDomain(data!!.weatherCache.weatherForecastResponse))
    } else {
        DomainResource.error(this.message!!, null)
    }
}

fun toDomain(response: WeatherForecastResponse): WeatherForecast {
    return WeatherForecast(
        toCityDomain(response.city),
        response.cnt,
        response.cod,
        toWeatherListDomain(response.list),
        response.message
    )
}

fun toCityDomain(city: City): com.lbnkosi.domain.model.weather.City {
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

fun toWeatherListDomain(list: List<CurrentWeatherResponse>): List<CurrentWeather> {
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

fun WeatherCache.toEntity(): WeatherEntity {
    return WeatherEntity(0, this.copy())
}

