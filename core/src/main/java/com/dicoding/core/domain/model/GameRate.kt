package com.dicoding.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GameRate (
    var gameId: Int,
    var name: String,
    var released: String,
    var backgroundImage: String,
    var rating: String,
    var ratingsCount: Int,
    var playtime: Int,
    var metacritic: Int,
    var isFavorite: Boolean
) : Parcelable