package com.lbnkosi.weatherapp.di

import com.lbnkosi.data.db.WeatherDao
import com.lbnkosi.data.repository.WeatherRepository
import com.lbnkosi.data.service.WeatherApiService
import com.lbnkosi.data.source.WeatherDataSource
import com.lbnkosi.domain.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesWeatherUseCase(aWeatherRepository: WeatherRepository): WeatherUseCase = WeatherUseCase(aWeatherRepository)

    @Provides
    fun providesWeatherDataSource(weatherDao: WeatherDao, weatherApiService: WeatherApiService): WeatherDataSource = WeatherDataSource(weatherDao, weatherApiService)

}