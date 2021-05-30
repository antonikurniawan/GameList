package com.dicoding.core.domain.repository

import com.dicoding.core.data.Resource
import com.dicoding.core.domain.model.GameRate
import kotlinx.coroutines.flow.Flow

interface IGameRateRepository {
    fun getAllGameRate(): Flow<Resource<List<GameRate>>>

    fun getFavoriteGameRate(): Flow<List<GameRate>>

    fun setFavoriteGameRate(gameRate: GameRate, state: Boolean)
}