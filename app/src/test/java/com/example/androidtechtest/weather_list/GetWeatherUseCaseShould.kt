package com.example.androidtechtest.weather_list

import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.domain.repository.AppRepository
import com.example.androidtechtest.domain.use_cases.GetWeatherUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetWeatherUseCaseShould {

    private lateinit var appRepository: AppRepository
    private lateinit var getWeatherUseCase: GetWeatherUseCase
    private val weather :Weather = mock()
    @Before
    fun setup(){
        appRepository = mock()
        getWeatherUseCase = GetWeatherUseCase(appRepository)
    }

    @Test
    fun returnWeatherForUsecaseInSuccess()  = runTest{
        `when`(appRepository.getWeather("Pune")).thenReturn(
            weather
        )
        getWeatherUseCase.invoke("Pune").onEach {
                Assert.assertEquals(weather,it.data)
        }
    }

    @Test
    fun returnErrorForUsecaseInSuccess()  = runTest{
        `when`(appRepository.getWeather("Pune")).thenThrow(
            RuntimeException("Something Went Wrong")
        )
        getWeatherUseCase.invoke("Pune").onEach {
            Assert.assertEquals("Something Went Wrong",it.message)
        }
    }
}