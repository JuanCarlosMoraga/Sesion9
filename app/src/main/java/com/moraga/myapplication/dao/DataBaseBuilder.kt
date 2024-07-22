package com.moraga.myapplication.dao

import android.content.Context
import androidx.room.Room

object DataBaseBuilder {
    @Volatile
    private var INSTANCE:AppDataBase? = null
    fun getIntance(context: Context):AppDataBase{
        return INSTANCE ?: synchronized(this) {
            val Instance = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "App database"
            ).build()
            INSTANCE = Instance
            Instance
        }
    }
}