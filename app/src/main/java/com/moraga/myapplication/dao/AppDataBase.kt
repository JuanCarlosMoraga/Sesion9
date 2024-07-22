package com.moraga.myapplication.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moraga.myapplication.entities.City

@Database(entities = [City::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun CityDao():CityDao
}