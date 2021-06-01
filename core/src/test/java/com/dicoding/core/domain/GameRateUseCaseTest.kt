package com.dicoding.core.domain

import androidx.lifecycle.asLiveData
import com.dicoding.core.data.GameRateRepository
import com.dicoding.core.data.Resource
import com.dicoding.core.domain.model.GameRate
import com.dicoding.core.domain.repository.IGameRateRepository
import com.dicoding.core.domain.usecase.GameRateInteractor
import com.dicoding.core.domain.usecase.GameRateUseCase
import com.dicoding.core.utils.DataDummy
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GameRateUseCaseTest {
    private lateinit var gameRateUseCase: GameRateUseCase
    private lateinit var dummyGameRateList: Flow<Resource<List<GameRate>>>
//    try {
//        flow.collect { value ->
//            println("Received $value")
//        }
//    } catch (e: Exception) {
//        println("The flow has thrown an exception: $e")
//    }
//            Flow<Resource<DataDummy.generateDummyGameRateResponse()>>

    @Mock
    private lateinit var iGameRateRepository: IGameRateRepository

    @Mock
    private lateinit var gameRateRepository: GameRateRepository

    @Before
    fun setUp(){
//        gameRateUseCase = GameRateInteractor(iGameRateRepository)

        dummyGameRateList = flow {
            emit(Resource.Success(DataDummy.generateDataDummyGameRate()))
        }

        gameRateUseCase = GameRateInteractor(iGameRateRepository)
        `when`(iGameRateRepository.getAllGameRate()).thenReturn(dummyGameRateList)
    }

    @Test
    fun getAllGameRateTest(){
        val gameRate = gameRateUseCase.getAllGameRate()

        verify(iGameRateRepository).getAllGameRate()
        verifyNoMoreInteractions(iGameRateRepository)
        assertEquals(gameRate, dummyGameRateList)

//        @Test fun `should get data from repository`() {
//            val message = messageUseCase.getMessage(NAME)
//
//            Mockito.verify(messageRepository).getWelcomeMessage(NAME)
//            Mockito.verifyNoMoreInteractions(messageRepository)
//            Assert.assertEquals("Hello $NAME Welcome to Clean Architecture", message.welcomeMessage)
//        }
    }

//    @Test
//    fun getFavoriteGameRate(){
//
//    }

//    @Test
//    fun setFavoriteGameRate(){
//
//    }
}