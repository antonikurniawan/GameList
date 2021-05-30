package com.dicoding.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gameRate")
data class GameRateEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "gameId")
    var gameId: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "backgroundImage")
    var backgroundImage: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "ratingsCount")
    var ratingsCount: Int,

    @ColumnInfo(name = "playtime")
    var playtime: Int,

    @ColumnInfo(name = "metacritic")
    var metacritic: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
