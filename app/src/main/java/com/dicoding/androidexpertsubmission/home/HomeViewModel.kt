package com.dicoding.androidexpertsubmission.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.usecase.GameRateUseCase

class HomeViewModel(gameRateUseCase: GameRateUseCase) :ViewModel() {
    val gameRate = gameRateUseCase.getAllGameRate().asLiveData()
}