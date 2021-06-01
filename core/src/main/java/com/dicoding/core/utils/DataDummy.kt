package com.dicoding.core.utils

import com.dicoding.core.data.source.remote.response.GameRateResponse
import com.dicoding.core.data.source.remote.response.ListGameRateResponse
import com.dicoding.core.domain.model.GameRate

object DataDummy {

    fun generateDataDummyGameRate(): List<GameRate>{
        val gameRate = ArrayList<GameRate>()
        gameRate.add(GameRate(
            1,
            "Minecraft",
            "18-11-2011",
            "https://cdn-2.tstatic.net/makassar/foto/bank/images/minecraft-2020.jpg",
            "4.7",
            17304,
            10,
            80,
            false
        ))

        gameRate.add(GameRate(
            2,
            "Terraria",
            "16-5-2011",
            "https://jagatplay.com/wp-content/uploads/2020/04/terraria1.png",
            "4.8",
            18304,
            12,
            90,
            false
        ))

        return gameRate

    }

//    fun generateDummyGameRateListResponse(): ListGameRateResponse {
//        return ListGameRateResponse(
//            2,
//            "link previous dummy",
//            "link next dummy",
//            generateDummyGameRateResponse()
//        )
//    }

//    Flow<Resource<List<GameRate>>>
    fun generateDummyGameRateResponse(): List<GameRateResponse> {
        val gameRateResponse = ArrayList<GameRateResponse>()
        gameRateResponse.add(GameRateResponse(
            1,
            "Minecraft",
            "18-11-2011",
            "https://cdn-2.tstatic.net/makassar/foto/bank/images/minecraft-2020.jpg",
            "4.7",
            17304,
            10,
            80
        ))

        GameRateResponse(
            2,
            "Terraria",
            "16-5-2011",
            "https://jagatplay.com/wp-content/uploads/2020/04/terraria1.png",
            "4.8",
            18304,
            12,
            90
        )
        return gameRateResponse
    }
}