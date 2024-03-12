package com.example.androidtechtest.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.androidtechtest.data.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * from fav_table")
    fun getFavorites():Flow<List<Favorite>>

    @Query("SELECT * from fav_table where city=:city")
    suspend fun getFavByCity(city :String): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}