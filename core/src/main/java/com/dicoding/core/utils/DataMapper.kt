package com.dicoding.core.utils

import com.dicoding.core.data.source.local.entity.GameRateEntity
import com.dicoding.core.data.source.remote.response.GameRateResponse
import com.dicoding.core.domain.model.GameRate

object DataMapper {
    fun mapResponseToEntities(input: List<GameRateResponse>): List<GameRateEntity> {
        val gameRateList = ArrayList<GameRateEntity>()
        input.map {
            val gameRate = GameRateEntity(
                gameId = it.id,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                playtime = it.playtime,
                metacritic = it.metacritic,
                isFavorite = false
            )
            gameRateList.add(gameRate)
        }
        return gameRateList
    }

    fun mapEntitiesToDomain(input: List<GameRateEntity>): List<GameRate> =
        input.map {
            GameRate(
                 gameId = it.gameId,
                 name = it.name,
                 released = it.released,
                 backgroundImage = it.backgroundImage,
                 rating = it.rating,
                 ratingsCount = it.ratingsCount,
                 playtime = it.playtime,
                 metacritic = it.metacritic,
                 isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: GameRate) = GameRateEntity(
         gameId = input.gameId,
         name = input.name,
         released = input.released,
         backgroundImage = input.backgroundImage,
         rating = input.rating,
         ratingsCount = input.ratingsCount,
         playtime = input.playtime,
         metacritic = input.metacritic,
         isFavorite = input.isFavorite
    )

}