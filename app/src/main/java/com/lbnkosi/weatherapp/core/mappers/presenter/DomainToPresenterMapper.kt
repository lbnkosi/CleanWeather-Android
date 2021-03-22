package com.lbnkosi.weatherapp.core.mappers.presenter

import com.lbnkosi.domain.enums.DMResourceStatus
import com.lbnkosi.domain.model.resource.DMResource
import com.lbnkosi.domain.model.weather.*
import com.lbnkosi.weatherapp.core.models.presenter.*
import com.lbnkosi.weatherapp.core.models.resource.Resource

fun DMResource<DMWeatherForecast>.toPresenter(): Resource<UIWeatherForecast> {
    return if (this.resourceStatus == DMResourceStatus.SUCCESS) {
        Resource.success(
            toUIWeatherHolder(this.data!!)
        )
    } else {
        Resource.error(this.message!!, null)
    }
}

fun toUIWeatherHolder(holder: DMWeatherForecast): UIWeatherForecast {
    return holder.toPresenter()
}
