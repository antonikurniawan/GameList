package com.dicoding.core.data

import com.dicoding.core.data.source.local.LocalDataSource
import com.dicoding.core.data.source.remote.RemoteDataSource
import com.dicoding.core.data.source.remote.network.ApiResponse
import com.dicoding.core.data.source.remote.response.GameRateResponse
import com.dicoding.core.domain.model.GameRate
import com.dicoding.core.domain.repository.IGameRateRepository
import com.dicoding.core.utils.AppExecutors
import com.dicoding.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRateRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRateRepository {

    override fun getAllGameRate(): Flow<Resource<List<GameRate>>> =
        object : NetworkBoundResource<List<GameRate>, List<GameRateResponse>>() {
            override fun loadFromDB(): Flow<List<GameRate>> {
                return localDataSource.getAllGameRate().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<GameRate>?): Boolean =
                data==null || data.isEmpty()
//                    true

            override suspend fun createCall(): Flow<ApiResponse<List<GameRateResponse>>> =
                remoteDataSource.getAllGameRate()


            override suspend fun saveCallResult(data: List<GameRateResponse>) {
                val gameRateList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertGameRate(gameRateList)
            }

        }.asFlow()
    //=======================

    override fun getFavoriteGameRate(): Flow<List<GameRate>> {
        return localDataSource.getFavoriteGameRate().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGameRate(gameRate: GameRate, state: Boolean) {
        val gameRateEntity = DataMapper.mapDomainToEntity(gameRate)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGameRate(gameRateEntity, state) }
    }
}