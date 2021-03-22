package com.lbnkosi.weatherapp.di

import com.lbnkosi.data.repository.WeatherRepository
import com.lbnkosi.domain.repository.ITWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceBindingModule {

    @Singleton
    @Binds
    abstract fun bindWeatherRepository(weatherRepository: WeatherRepository): ITWeatherRepository

}