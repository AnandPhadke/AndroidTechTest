package com.example.androidtechtest.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidtechtest.presentation.state.DataOrException
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appRepository: AppRepository) :ViewModel() {

    suspend fun getWeatherData(city: String) : DataOrException<Weather, Boolean, Exception> {
        return appRepository.getWeather(city)
    }

    val data : MutableState<DataOrException<Weather, Boolean, Exception>>
    = mutableStateOf(DataOrException(null,true,Exception("")))


}