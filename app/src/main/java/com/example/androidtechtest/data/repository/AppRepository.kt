package com.example.androidtechtest.data.repository

import android.util.Log
import com.example.androidtechtest.presentation.state.DataOrException
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.data.network.AppApi
import javax.inject.Inject

class AppRepository @Inject constructor( private val api: AppApi){
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(cityQuery)
        } catch (e:Exception){
            Log.d("getWeather" , "e    :  $e")
            return DataOrException(error = e)
        }
        return DataOrException(data = response)
    }
}