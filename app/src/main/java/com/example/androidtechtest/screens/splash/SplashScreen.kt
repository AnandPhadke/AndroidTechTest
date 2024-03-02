package com.example.androidtechtest.screens.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.draw.scale
import com.example.androidtechtest.R
import com.example.androidtechtest.navigation.AppScreens

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = null, block = {
        delay(2000)
        navController.navigate(AppScreens.MainScreen.name)
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