package com.moraga.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.moraga.myapplication.entities.City

@Dao
abstract class CityDao {
    @Insert
    abstract suspend fun insert(city: City)

    @Query("select * from cities")
    abstract fun getAllCities():LiveData<List<City>>

    @Update
    abstract suspend fun update(city: City)

    @Delete
    abstract suspend fun delete(city: City)
}