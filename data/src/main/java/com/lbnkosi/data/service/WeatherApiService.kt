package com.lbnkosi.data.service

import com.lbnkosi.data.model.response.WeatherForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    companion object {
        const val QUERY_LAT = "lat"
        const val QUERY_LON = "lon"
        const val PATH = "forecast"
        const val QUERY_UNIT = "units"
        const val QUERY_APP_ID = "appid"
    }

    @GET(PATH)
    fun getWeatherForecast(
        @Query(QUERY_LAT) aLat: String,
        @Query(QUERY_LON) aLon: String,
        @Query(QUERY_UNIT) aUnit: String,
        @Query(QUERY_APP_ID) aAppID: String
    ): Call<WeatherForecastResponse>

}