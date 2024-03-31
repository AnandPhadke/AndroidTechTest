package com.example.androidtechtest.weather_list

import com.example.androidtechtest.MainCoroutineRule
import com.example.androidtechtest.core.common.Resource
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.domain.use_cases.GetWeatherUseCase
import com.example.androidtechtest.presentation.screens.main.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class GetWeatherViewModelShould {

    @get:Rule
    val mainCoroutineRule  = MainCoroutineRule()

    private val getWeatherUseCase: GetWeatherUseCase  = mock()
    private lateinit var weatherViewModel : MainViewModel
    private val weather : Weather = mock()

    @Before
    fun setup(){
        weatherViewModel = MainViewModel(getWeatherUseCase)
    }

    @Test
    fun validateProgressBar() = runTest{
        `when`(getWeatherUseCase.invoke("Pune")).thenReturn(
            flow {
                emit(Resource.Loading())
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true,weatherViewModel.weatherDataStateHolder.value.loading)
    }

    @Test
    fun validateSuccess() = runTest{
        `when`(getWeatherUseCase.invoke("Pune")).thenReturn(
            flow {
                emit(Resource.Success(weather))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(weather,weatherViewModel.weatherDataStateHolder.value.data)
    }

    @Test
    fun vslidateError() = runTest{
        `when`(getWeatherUseCase.invoke("Pune")).thenReturn(
            flow {
                emit(Resource.Error("Something Went Wrong"))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals("Something Went Wrong",weatherViewModel.weatherDataStateHolder.value.error)
    }
}