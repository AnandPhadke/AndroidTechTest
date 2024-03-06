package com.example.androidtechtest.di

import android.content.Context
import androidx.room.Room
import com.example.androidtechtest.data.AppDao
import com.example.androidtechtest.data.AppDatabase
import com.example.androidtechtest.network.AppApi
import com.example.androidtechtest.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAppApi() :AppApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AppApi::class.java)
    }
    @Singleton
    @Provides
    fun provideAppDao(appDatabase: AppDatabase):AppDao = appDatabase.appDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext : Context) :AppDatabase
        = Room.databaseBuilder(appContext,AppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration().build()


}