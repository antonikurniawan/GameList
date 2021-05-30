package com.dicoding.core.data.source.local

import com.dicoding.core.data.source.local.entity.GameRateEntity
import com.dicoding.core.data.source.local.room.GameRateDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameRateDao: GameRateDao) {

    fun getAllGameRate(): Flow<List<GameRateEntity>> = gameRateDao.getAllGameRate()

    fun getFavoriteGameRate(): Flow<List<GameRateEntity>> = gameRateDao.getFavoriteGameRate()

    fun insertGameRate(gameRateList: List<GameRateEntity>) = gameRateDao.insertGameRate(gameRateList)

    fun setFavoriteGameRate(gameRate: GameRateEntity, newState: Boolean) {
        gameRate.isFavorite = newState
        gameRateDao.updateFavoriteGameRate(gameRate)
    }
}