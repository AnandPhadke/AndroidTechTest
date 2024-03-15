package com.example.androidtechtest.domain.di

import com.example.androidtechtest.data.network.AppApi
import com.example.androidtechtest.data.repository.AppRepositoryImpl
import com.example.androidtechtest.domain.repository.AppRepository
import com.example.androidtechtest.domain.use_cases.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideAppRepository(appApi: AppApi) : AppRepository{
        return AppRepositoryImpl(appApi)
    }

    @Provides
    fun provideWeatherUseCase(appRepository: AppRepository) : GetWeatherUseCase{
      return GetWeatherUseCase(appRepository)
    }
}