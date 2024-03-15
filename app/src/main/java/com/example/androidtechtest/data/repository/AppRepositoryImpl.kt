package com.example.androidtechtest.data.repository

import android.util.Log
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.data.network.AppApi
import com.example.androidtechtest.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val api: AppApi) : AppRepository{
    override suspend fun getWeather(cityQuery: String): Weather {
        val response = try {
            api.getWeather(cityQuery)
        } catch (e:Exception){
            Log.d("getWeather" , "e    :  $e")
//            return DataOrException(error = e)
        }
        return response as Weather
    }
}