package com.dicoding.core.data.source.local.room

import androidx.room.*
import com.dicoding.core.data.source.local.entity.GameRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameRateDao {

    @Query("SELECT * FROM gameRate")
    fun getAllGameRate(): Flow<List<GameRateEntity>>

    @Query("SELECT * FROM gameRate WHERE isFavorite = 1")
    fun getFavoriteGameRate(): Flow<List<GameRateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGameRate(gameRate: List<GameRateEntity>)

    @Update
    fun updateFavoriteGameRate(gameRate: GameRateEntity)

}