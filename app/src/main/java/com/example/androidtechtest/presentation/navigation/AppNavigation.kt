package com.example.androidtechtest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidtechtest.presentation.screens.favorite.FavoriteScreen
import com.example.androidtechtest.presentation.screens.main.MainScreen
import com.example.androidtechtest.presentation.screens.main.MainViewModel
import com.example.androidtechtest.presentation.screens.search.SearchScreen
import com.example.androidtechtest.presentation.screens.splash.SplashScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        val route = AppScreens.MainScreen.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                })){ navBack ->
            navBack.arguments?.getString("city").let { city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel,
                    city = city)
            }


        }
        composable(AppScreens.SearchScreen.name){
            var mainViewModel = hiltViewModel<MainViewModel>()
            SearchScreen(navController = navController,mainViewModel)
        }

        composable(AppScreens.FavoriteScreen.name){
            FavoriteScreen(navController = navController)
        }

    }
}