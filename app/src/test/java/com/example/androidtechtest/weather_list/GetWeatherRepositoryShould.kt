package com.example.androidtechtest.weather_list

import com.example.androidtechtest.MainCoroutineRule
import com.example.androidtechtest.core.utils.Constants
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.data.network.AppApi
import com.example.androidtechtest.data.repository.AppRepositoryImpl
import com.example.androidtechtest.domain.repository.AppRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetWeatherRepositoryShould {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private lateinit var appRepository: AppRepository
    private lateinit var appApi: AppApi
    private val weather:Weather = mock()

    @Before
    fun setup(){
        appApi = mock()
        appRepository = AppRepositoryImpl(appApi)
    }

    @Test
    fun returnSuccessFromBackend() = runTest {
        `when`(appApi.getWeather("Pune","imperial", Constants.API_KEY)).thenReturn(
            weather
        )
        val result = appRepository.getWeather("Pune")
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(weather,result)
    }

}