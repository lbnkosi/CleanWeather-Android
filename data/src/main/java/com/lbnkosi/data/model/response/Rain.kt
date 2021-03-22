package com.lbnkosi.data.model.response

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h") val ThreeH: Double = 0.0
)