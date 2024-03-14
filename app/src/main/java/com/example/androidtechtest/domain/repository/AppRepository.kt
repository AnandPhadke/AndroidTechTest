package com.example.androidtechtest.domain.repository

import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.presentation.state.DataOrException

interface AppRepository {
    suspend fun getWeather(cityQuery: String): Weather
}