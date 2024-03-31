package com.example.androidtechtest.domain.use_cases

import com.example.androidtechtest.core.common.Resource
import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val appRepository: AppRepository){

    operator fun invoke(cityString : String):Flow<Resource<Weather>> = flow{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = appRepository.getWeather(cityString)))
        } catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }


}