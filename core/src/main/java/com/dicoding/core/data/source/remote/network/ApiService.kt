package com.dicoding.core.data.source.remote.network

import com.dicoding.core.data.source.remote.response.ListGameRateResponse
import retrofit2.http.GET

interface ApiService {

    companion object{
        const val TOKEN_KEY = "b791038295cf4d71930a98e13fea466a"
    }

    @GET("games?key=$TOKEN_KEY")
    suspend fun getList(): ListGameRateResponse

}