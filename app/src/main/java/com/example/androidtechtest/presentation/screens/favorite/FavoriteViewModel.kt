package com.example.androidtechtest.presentation.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtechtest.data.model.Favorite
import com.example.androidtechtest.data.repository.AppDatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: AppDatabaseRepository)
    : ViewModel(){
        private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
        val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFavorites().distinctUntilChanged()
                .collect { listOfFavs ->
                    if (listOfFavs.isNullOrEmpty()) {
                        Log.d("TAG", ": Empty favs ")
                    }else {
                         _favList.value = listOfFavs
                        Log.d("FAVS", ":${favList.value} ")
                    }
                }
        }
    }
    fun insertFavorite(favorite: Favorite) = viewModelScope.launch { repository.insertFavorite(favorite) }
    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch { repository.deleteFavorite(favorite) }


    }