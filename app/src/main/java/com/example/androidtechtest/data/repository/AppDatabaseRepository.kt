package com.example.androidtechtest.data.repository

import com.example.androidtechtest.data.database.AppDao
import com.example.androidtechtest.data.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppDatabaseRepository @Inject constructor(private val appDao : AppDao) {

    suspend fun getFavorites(): Flow<List<Favorite>> = appDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = appDao.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = appDao.updateFavorite(favorite)
    suspend fun deleteFavorite(favorite: Favorite) = appDao.deleteFavorite(favorite)
    suspend fun getFavById(city: String): Favorite = appDao.getFavByCity(city)
}