package com.dicoding.androidexpertsubmission.favorite.di

import com.dicoding.androidexpertsubmission.favorite.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}