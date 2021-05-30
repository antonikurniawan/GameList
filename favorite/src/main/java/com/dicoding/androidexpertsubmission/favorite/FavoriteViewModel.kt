package com.dicoding.androidexpertsubmission.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.usecase.GameRateUseCase

class FavoriteViewModel(gameRateUseCase: GameRateUseCase) : ViewModel(){
    val favoriteGameRate = gameRateUseCase.getFavoriteGameRate().asLiveData()
}