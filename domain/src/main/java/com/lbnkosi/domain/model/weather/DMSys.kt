package com.lbnkosi.domain.model.weather

data class DMSys(
    val country: String = "",
    val id: Int = 0,
    val message: Double = 0.0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val type: Int = 0
)