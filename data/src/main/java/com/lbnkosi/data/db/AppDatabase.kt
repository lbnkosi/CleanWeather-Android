package com.lbnkosi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lbnkosi.data.model.entity.WeatherEntity
import com.lbnkosi.data.typeconverter.WeatherTypeConverter

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
@TypeConverters(WeatherTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object{
        const val DATABASE_NAME : String = "ROOM_DB"
    }
}