package com.lbnkosi.data.mappers

import com.lbnkosi.data.enums.DTResourceStatus.*
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.model.resource.DTResource
import com.lbnkosi.data.model.response.*
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

fun weatherResponseToDomain(response: CurrentWeatherResponse): DMCurrentWeather {
    return DMCurrentWeather(
        response.base,
        toCloud(response.clouds),
        response.cod,
        toCoord(response.coord),
        response.dt,
        response.id,
        toMain(response.main),
        response.name,
        toSys(response.sys),
        response.timezone,
        response.visibility,
        toWeather(response.weather),
        toWind(response.wind),
        response.dt_txt,
        response.pop,
        DMRain(response.rain.ThreeH),
    )
}

fun toCloud(clouds: Clouds) =
    DMClouds(clouds.all)

fun toWind(wind: Wind) =
    DMWind(wind.deg, wind.speed)

fun toCoord(coord: Coord) =
    DMCoord(coord.lat, coord.lon)

fun toSys(sys: Sys) =
    DMSys(sys.country, sys.id, sys.message, sys.sunrise, sys.sunset, sys.type)

fun toWeather(list: List<Weather>) =
    list.map { DMWeather(it.description, it.icon, it.id, it.main) }

fun toMain(main: Main) =
    DMMain(main.feels_like, main.humidity, main.pressure, main.temp, main.temp_max, main.temp_min)

fun weatherForecastResponseToDomain(response: WeatherForecastResponse): DMWeatherForecast {
    return DMWeatherForecast(
        toCity(response.city),
        response.cnt,
        response.cod,
        toWeatherList(response.list),
        response.message
    )
}

fun toCity(city: City) =
    DMCity(
        DMCoord(city.coord.lat, city.coord.lon),
        city.country,
        city.id,
        city.name,
        city.population,
        city.sunrise,
        city.sunset,
        city.timezone
    )

fun toWeatherList(list: List<CurrentWeatherResponse>) =
    list.map {
        DMCurrentWeather(
            it.base,
            DMClouds(it.clouds.all),
            it.cod,
            DMCoord(it.coord.lat, it.coord.lon),
            it.dt,
            it.id,
            DMMain(
                it.main.feels_like,
                it.main.humidity,
                it.main.pressure,
                it.main.temp,
                it.main.temp_max,
                it.main.temp_min
            ),
            it.name,
            DMSys(
                it.sys.country,
                it.sys.id,
                it.sys.message,
                it.sys.sunrise,
                it.sys.sunset,
                it.sys.type
            ),
            it.timezone,
            it.visibility,
            it.weather.map { w -> DMWeather(w.description, w.icon, w.id, w.main) },
            DMWind(it.wind.deg, it.wind.speed),
            it.dt_txt,
            it.pop,
            DMRain(it.rain.ThreeH)
        )
    }

fun WeatherCache.toEntity(): WeatherEntity {
    return WeatherEntity(
        0,
        this.copy()
    )
}

