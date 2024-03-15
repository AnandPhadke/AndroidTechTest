package com.example.androidtechtest.domain.repository

import com.example.androidtechtest.data.model.Weather

interface AppRepository {
    suspend fun getWeather(cityQuery: String): Weather
}