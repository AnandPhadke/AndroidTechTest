package com.example.androidtechtest.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.androidtechtest.R
import com.example.androidtechtest.data.DataOrException
import com.example.androidtechtest.model.Weather
import com.example.androidtechtest.model.WeatherItem
import com.example.androidtechtest.navigation.AppScreens
import com.example.androidtechtest.utils.Constants.BASE_URL_IMAGE
import com.example.androidtechtest.utils.formatDate
import com.example.androidtechtest.utils.formatDecimals
import com.example.androidtechtest.widgets.ShowAppBar

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel(),
               city: String?) {
    val selectedCity: String = if (city!!.isBlank()) "Pune" else city
    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue = DataOrException(loading = true)){
            value = mainViewModel.getWeatherData(selectedCity)
        }.value
    if(weatherData.loading == true){
        CircularProgressIndicator()
    } else {
        weatherData.data?.let { ShowUI(it, navController) }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShowUI(weather: Weather, navController: NavController) {
   Scaffold(topBar ={
       ShowAppBar(title = weather.city  .name, elevation = dimensionResource(id = R.dimen.elevation_5dp), navController = navController,
       onSearchClicked = {
            navController.navigate(AppScreens.SearchScreen.name)
       },
       onFavoriteClicked = {
           navController.navigate(AppScreens.FavoriteScreen.name)
       })
   })
   {
       MainContent(data = weather)
   }
}
@Composable
fun MainContent(data: Weather){
    val weatherItem = data.list.get(0)
    //TODO dont static
    val imageUrl = "$BASE_URL_IMAGE${weatherItem.weather[0].icon}.png"
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        //TODO
        Text(text = formatDate(data.list.get(0).dt), modifier = Modifier.padding(5.dp),
        color = MaterialTheme.colors.secondary)

        Surface(modifier = Modifier.padding(4.dp)) {

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                WeatherStateImage(imageUrl)
                Text(text = formatDecimals(weatherItem.temp.day) + "º", style = MaterialTheme.typography.h4)
                Text(text = weatherItem.weather[0].main)

            }            
        }

    Divider()
    Text(text = "This week", style = MaterialTheme.typography.subtitle1)
    Surface() {
        LazyColumn(modifier = Modifier.padding(2.dp),
            contentPadding = PaddingValues(1.dp)) {
            items(items = data.list) { item: WeatherItem ->
                    WeatherDetailRow(weather = item)
                }
            }
        }
    }
}
@Composable
fun WeatherDetailRow(weather: WeatherItem) {
    //TODO
    val imageUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"
    Surface(
        Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        color = Color.White) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                formatDate(weather.dt),
                modifier = Modifier.padding(start = 5.dp)
            )
            WeatherStateImage(imageUrl = imageUrl)
            Surface(modifier = Modifier.padding(0.dp),
                shape = CircleShape
            ) {
                Text(weather.weather[0].description,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.caption)

            }
            Text(text = formatDecimals(weather.temp.max) + "º",
                    color = Color.Blue.copy(alpha = 0.7f),
                    fontWeight = FontWeight.Bold
                )
        }
    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(painter = rememberImagePainter(data = imageUrl,
        builder = {fallback(R.drawable.ic_launcher_foreground)
                    placeholder(R.drawable.ic_launcher_foreground)
                    error(R.drawable.ic_launcher_foreground)}), contentDescription = "WeatherImage",
    modifier = Modifier.size(60.dp))
}
