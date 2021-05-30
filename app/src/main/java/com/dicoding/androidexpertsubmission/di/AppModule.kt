package com.dicoding.androidexpertsubmission.di

import com.dicoding.core.domain.usecase.GameRateInteractor
import com.dicoding.core.domain.usecase.GameRateUseCase
import com.dicoding.androidexpertsubmission.detail.DetailViewModel
import com.dicoding.androidexpertsubmission.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameRateUseCase> { GameRateInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}