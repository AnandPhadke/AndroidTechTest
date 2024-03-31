package com.example.androidtechtest.weather_list

import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.androidtechtest.presentation.ui.MainActivity
import org.junit.Test

class WeatherListFeature {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun validateProgressBarVisible(){
        composeRule.apply{
            onNodeWithTag("progress").assertIsDisplayed()
        }
    }

    @Test
    fun validateIsMovieListVisible(){
        composeRule.apply{
            Thread.sleep(2000)
            onNodeWithTag("weather_list").assertIsDisplayed()
        }
    }

}