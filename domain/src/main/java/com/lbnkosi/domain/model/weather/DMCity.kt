package com.lbnkosi.domain.model.weather

data class DMCity(
    val coord: DMCoord = DMCoord(),
    val country: String = "",
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val timezone: Int = 0
)