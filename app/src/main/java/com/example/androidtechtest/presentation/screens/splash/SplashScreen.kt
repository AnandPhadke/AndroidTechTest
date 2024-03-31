package com.example.androidtechtest.presentation.screens.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidtechtest.R
import com.example.androidtechtest.presentation.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val defaultCity = "Pune"
    LaunchedEffect(key1 = null, block = {
        delay(2000)
        navController.navigate(AppScreens.MainScreen.name + "/$defaultCity")
    })
    launch()

}

@Composable
fun launch(){
    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(
            width = 2.dp, color = Color.LightGray
        )
    ) {
        Column(modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(95.dp))
            Text(text = "TechApp",
                color = Color.LightGray)
        }


    }
}