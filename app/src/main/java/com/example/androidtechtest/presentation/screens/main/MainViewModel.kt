package com.example.androidtechtest.presentation.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechtest.core.common.Resource
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.domain.use_cases.GetWeatherUseCase
import com.example.androidtechtest.presentation.state.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase) :ViewModel() {

    private val _weatherDataStateHolder = mutableStateOf(DataOrException<Weather, Boolean, Exception>())
    val weatherDataStateHolder : State<DataOrException<Weather, Boolean, Exception>> = _weatherDataStateHolder


    fun getWeather(city: String) {
        viewModelScope.launch {
            if (city != null) {
                getWeatherUseCase(city).onEach {
                    when(it){
                        is Resource.Loading ->{
                            _weatherDataStateHolder.value = DataOrException(loading = true)
                        }

                        is Resource.Success -> {
                            _weatherDataStateHolder.value = DataOrException(data = it.data)
                        }

                        is Resource.Error -> {
                            _weatherDataStateHolder.value = DataOrException(error = it.message.toString())
                        }

                    }
                }.launchIn(viewModelScope)
            }
        }
    }
}