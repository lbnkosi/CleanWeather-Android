package com.lbnkosi.data.source

import com.lbnkosi.data.db.WeatherDao
import com.lbnkosi.data.enums.DTResourceStatus
import com.lbnkosi.data.mappers.toEntity
import com.lbnkosi.data.model.cache.WeatherCache
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.model.resource.DTResource
import com.lbnkosi.data.model.response.WeatherForecastResponse
import com.lbnkosi.data.service.WeatherApiService
import com.lbnkosi.data.utils.NetworkConstants.APP_ID
import com.lbnkosi.data.utils.WeatherAlias
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val mWeatherDao: WeatherDao,
    private val mWeatherApiService: WeatherApiService
) {

    suspend fun query(aIsOffline: Boolean, aLat: String, aLon: String, aUnit: String): Flow<DTResource<WeatherEntity>> {
        return when {
            !aIsOffline -> {
                val response = fetchFromApi(aLat, aLon, aUnit)
                if (response.DTResourceStatus == DTResourceStatus.SUCCESS) {
                    val newCache = WeatherCache(weatherForecastResponse = response.data!!)
                    flow { emit(DTResource.success(saveCache(newCache.toEntity()))) }
                } else {
                    if (isCacheAvailable()) flow { emit(DTResource.success(fetchCache())) }
                    flow { emit(DTResource.error(response.message, null)) }
                }
            }
            isCacheAvailable() -> flow { emit(DTResource.success(fetchCache())) }
            else -> flow { emit(DTResource.error("Your device is offline and there is no offline data to display. Please make sure you are connected to WiFi to continue", null)) }
        }
    }

    private suspend fun fetchFromApi(aLat: String, aLon: String, aUnit: String): DTResource<WeatherForecastResponse> {
        val response = mWeatherApiService.getWeatherForecast(aLat, aLon, aUnit, APP_ID).awaitResponse()
        return when {
            response.isSuccessful -> DTResource.success(response.body())
            else -> DTResource.error(response.message(), response.body())
        }
    }

    private suspend fun saveCache(weatherEntity: WeatherEntity): WeatherEntity {
        mWeatherDao.saveWeatherEntity(weatherEntity)
        return mWeatherDao.getWeatherEntity()
    }

    private suspend fun fetchCache(): WeatherEntity {
        return mWeatherDao.getWeatherEntity()
    }

    private suspend fun isCacheAvailable(): Boolean {
        return mWeatherDao.availableWeather() > 0
    }

    private suspend fun deleteCache() {
        mWeatherDao.deleteWeatherEntity()
    }
}