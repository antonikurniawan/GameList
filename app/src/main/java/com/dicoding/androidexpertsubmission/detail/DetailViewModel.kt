package com.dicoding.androidexpertsubmission.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.model.GameRate
import com.dicoding.core.domain.usecase.GameRateUseCase

class DetailViewModel(private val gameRateUseCase: GameRateUseCase) : ViewModel() {
    fun setFavoriteGameRate(gameRate: GameRate, newStatus: Boolean) =
        gameRateUseCase.setFavoriteGameRate(gameRate, newStatus)
}