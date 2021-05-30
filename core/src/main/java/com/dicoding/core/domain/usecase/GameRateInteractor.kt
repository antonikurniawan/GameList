package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.GameRate
import com.dicoding.core.domain.repository.IGameRateRepository

class GameRateInteractor(private val gamerateRepository: IGameRateRepository): GameRateUseCase {

    override fun getAllGameRate() = gamerateRepository.getAllGameRate()

    override fun getFavoriteGameRate() = gamerateRepository.getFavoriteGameRate()

    override fun setFavoriteGameRate(gameRate: GameRate, state: Boolean) = gamerateRepository.setFavoriteGameRate(gameRate, state)
}