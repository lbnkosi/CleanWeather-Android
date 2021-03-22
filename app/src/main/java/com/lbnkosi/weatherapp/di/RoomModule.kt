package com.lbnkosi.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.lbnkosi.data.db.AppDatabase
import com.lbnkosi.data.db.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesWeatherDatabase(@ApplicationContext aContext: Context): AppDatabase {
        return Room.databaseBuilder(aContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesWeatherDao(aAppDatabase: AppDatabase):WeatherDao {
        return aAppDatabase.weatherDao()
    }

}