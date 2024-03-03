package com.example.androidtechtest.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechtest.data.DataOrException
import com.example.androidtechtest.model.Weather
import com.example.androidtechtest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appRepository: AppRepository) :ViewModel() {

    suspend fun getWeatherData(city: String) : DataOrException<Weather,Boolean,Exception>{
        return appRepository.getWeather(city)
    }

    val data : MutableState<DataOrException<Weather,Boolean,Exception>>
    = mutableStateOf(DataOrException(null,true,Exception("")))


}