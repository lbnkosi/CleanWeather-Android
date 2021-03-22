package com.lbnkosi.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("city") val city: City = City(),
    @SerializedName("cnt") val cnt: Int = 0,
    @SerializedName("cod") val cod: String = "",
    @SerializedName("list") val list: List<CurrentWeatherResponse> = arrayListOf(),
    @SerializedName("message") val message: Int = 0
)