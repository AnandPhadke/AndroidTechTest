package com.example.androidtechtest.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechtest.core.common.Resource
import com.example.androidtechtest.presentation.state.DataOrException
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.domain.repository.AppRepository
import com.example.androidtechtest.domain.use_cases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase,
                                        savedStateHandle: SavedStateHandle) :ViewModel() {

    private val _weatherDataStateHolder = mutableStateOf(DataOrException<Weather, Boolean, Exception>())
    val weatherDataStateHolder : State<DataOrException<Weather, Boolean, Exception>> = _weatherDataStateHolder

    init {
            viewModelScope.launch {
                //savedStateHandle.getStateFlow()
            }
    }
    suspend fun getWeatherData(city: String) {
        viewModelScope.launch {
            getWeatherUseCase(city).onEach {
                when(it){
                    is Resource.Loading ->{

                    }
                    is Resource.Success -> {

                    }

                    is Resource.Error -> {

                    }

                }
            }.launchIn(viewModelScope)
        }
    }

    val data : MutableState<DataOrException<Weather, Boolean, Exception>>
    = mutableStateOf(DataOrException(null,true,Exception("")))


}