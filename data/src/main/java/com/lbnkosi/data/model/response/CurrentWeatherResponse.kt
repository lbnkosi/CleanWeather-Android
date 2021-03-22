package com.lbnkosi.data.model.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("base") val base: String = "",
    @SerializedName("clouds") val clouds: Clouds = Clouds(),
    @SerializedName("cod") val cod: Int = 0,
    @SerializedName("coord") val coord: Coord = Coord(),
    @SerializedName("dt") val dt: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("main") val main: Main = Main(),
    @SerializedName("name") val name: String = "",
    @SerializedName("sys") val sys: Sys = Sys(),
    @SerializedName("timezone") val timezone: Int = 0,
    @SerializedName("visibility") val visibility: Int = 0,
    @SerializedName("weather") val weather: List<Weather> = arrayListOf(),
    @SerializedName("wind") val wind: Wind = Wind(),
    @SerializedName("dt_txt") val dt_txt: String = "",
    @SerializedName("pop") val pop: Double = 0.0,
    @SerializedName("rain") val rain: Rain = Rain(),
)