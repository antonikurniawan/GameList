package com.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameRateResponse (
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("rating")
    val rating: String,

    @field:SerializedName("ratings_count")
    val ratingsCount: Int,

    @field:SerializedName("playtime")
    val playtime: Int,

    @field:SerializedName("metacritic")
    val metacritic: Int

)