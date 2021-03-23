package com.lbnkosi.weatherapp.core.extensions

import android.content.Context
import com.google.android.gms.maps.model.LatLng
import com.lbnkosi.weatherapp.core.enums.WeatherTypeEnum
import com.lbnkosi.weatherapp.core.commons.Constants
import com.lbnkosi.weatherapp.core.models.presenter.UICurrentWeather
import com.lbnkosi.weatherapp.core.models.presenter.UIWeather
import com.lbnkosi.weatherapp.core.util.NetworkUtil
import java8.util.stream.StreamSupport
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun Double.toUnicode() = this.roundToInt().toString() + Constants.METRIC_UNICODE

fun String.weatherType() = when {
    this.contains("snow", ignoreCase = true) -> WeatherTypeEnum.RAINY
    this.contains("clear", ignoreCase = true) -> WeatherTypeEnum.SUNNY
    this.contains("cloud", ignoreCase = true) -> WeatherTypeEnum.CLOUDY
    this.contains("rain", ignoreCase = true) -> WeatherTypeEnum.RAINY
    else -> WeatherTypeEnum.UNKNOWN
}

fun String.toDayOfWeek(): String {
    val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date: Date = inputFormat.parse(this)
    val formatter: DateFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
    return formatter.format(date)
}

fun String.toDate(): String {
    val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date: Date = inputFormat.parse(this)
    val formatter: DateFormat = SimpleDateFormat("dd-MMMM-yy", Locale.ENGLISH)
    return formatter.format(date)
}

fun List<UICurrentWeather>.filter(): List<UICurrentWeather> {
    val set: MutableSet<String> = HashSet()
    return StreamSupport.stream(this).filter { element -> set.add(element.dt_txt.toDayOfWeek()) }.collect(java8.util.stream.Collectors.toList())
}

fun shouldFetch(context: Context, latLng: LatLng): Boolean {
    return NetworkUtil.isConnectedOrConnecting(context) && latLng.isValid()
}

fun LatLng.isValid() : Boolean {
    return this.latitude != 0.0 && this.longitude != 0.0
}

fun List<UIWeather>.icon(): String {
    return "http://openweathermap.org/img/w/" + this[0].icon + ".png"
}
