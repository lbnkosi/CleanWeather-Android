package com.lbnkosi.weatherapp.core.enums

import com.lbnkosi.weatherapp.R

enum class WeatherTypeEnum(val mCover: String = "", val mColor: Int) {

    SUNNY("Sunny", R.color.sunny),
    CLOUDY("Cloudy", R.color.cloudy),
    RAINY("Rainy", R.color.rainy),
    UNKNOWN("Unknown", R.color.sunny);

}