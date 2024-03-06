package com.example.androidtechtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtechtest.model.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun appDao() : AppDao
}