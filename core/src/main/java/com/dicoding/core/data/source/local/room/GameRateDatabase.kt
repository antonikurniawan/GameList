package com.dicoding.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.core.data.source.local.entity.GameRateEntity

@Database(entities = [GameRateEntity::class], version = 1, exportSchema = false)
abstract class GameRateDatabase : RoomDatabase() {

    abstract fun gameRateDao(): GameRateDao

}