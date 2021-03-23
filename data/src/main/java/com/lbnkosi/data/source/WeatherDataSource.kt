package com.lbnkosi.data.source

import com.lbnkosi.data.db.WeatherDao
import com.lbnkosi.data.enums.ResourceStatus
import com.lbnkosi.data.mappers.toEntity
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.model.resource.Resource
import com.lbnkosi.data.model.response.WeatherForecastResponse
import com.lbnkosi.data.service.WeatherApiService
import com.lbnkosi.data.utils.NetworkConstants.APP_ID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val weatherDao: WeatherDao,
    private val weatherApiService: WeatherApiService
) {

    suspend fun query(
        isOffline: Boolean,
        latitude: String,
        longitude: String,
        units: String
    ): Flow<Resource<WeatherEntity>> {
        return when {
            !isOffline -> onlineQuery(latitude, longitude, units)
            isCacheAvailable() -> flow { emit(Resource.success(fetchCache())) }
            else -> flow { emit(Resource.error("Your device is offline and there is no offline data to display. Please make sure you are connected to WiFi to continue", null)) }
        }
    }

    private suspend fun onlineQuery(
        latitude: String,
        longitude: String,
        units: String
    ): Flow<Resource<WeatherEntity>> {
        val response = fetchFromApi(latitude, longitude, units)

        if (response.resourceStatus == ResourceStatus.SUCCESS) {
            return flow { emit(Resource.success(saveCache(WeatherCache(weatherForecastResponse = response.data!!).toEntity()))) }
        }

        return when {
            isCacheAvailable() -> flow { emit(Resource.success(fetchCache())) }
            else -> flow { emit(Resource.error(response.message, null)) }
        }
    }

    private suspend fun fetchFromApi(
        latitude: String,
        longitude: String,
        units: String
    ): Resource<WeatherForecastResponse> {
        val response = weatherApiService.getWeatherForecast(latitude, longitude, units, APP_ID).awaitResponse()

        return when {
            response.isSuccessful -> Resource.success(response.body())
            else -> Resource.error(response.message(), response.body())
        }
    }

    private suspend fun saveCache(weatherEntity: WeatherEntity): WeatherEntity {
        weatherDao.saveWeatherEntity(weatherEntity)
        return weatherDao.getWeatherEntity()
    }

    private suspend fun fetchCache(): WeatherEntity {
        return weatherDao.getWeatherEntity()
    }

    private suspend fun isCacheAvailable(): Boolean {
        return weatherDao.availableWeather() > 0
    }

    //TODO delete cache if it's older than the last day on the weather forecast
    private suspend fun deleteCache() {
        weatherDao.deleteWeatherEntity()
    }
}