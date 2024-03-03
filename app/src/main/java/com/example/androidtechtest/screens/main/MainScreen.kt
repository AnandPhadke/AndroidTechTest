package com.example.androidtechtest.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidtechtest.data.DataOrException
import com.example.androidtechtest.model.Weather
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    showData(mainViewModel)
}
@Composable
fun showData(mainViewModel: MainViewModel) {
    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue = DataOrException(loading = true)){
            value = mainViewModel.getWeatherData("Pune")
        }.value
    if(weatherData.loading == true){
        CircularProgressIndicator()
    } else {
        Text(text = "MainScreen     ${weatherData.data?.city?.country}")
    }
}
