package com.example.androidtechtest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_table")
data class Favorite(
    @PrimaryKey
    val city:String,

)