package com.example.androidtechtest

import com.example.androidtechtest.data.network.AppApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var appApi: AppApi


    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        appApi = Retrofit.Builder().baseUrl(mockWebServer.url("/")).
                addConverterFactory(GsonConverterFactory.create()).build().create(AppApi::class.java)
    }

    @Test
    fun testGetWeather() = runBlocking {
        val mockResponse  = MockResponse()
        mockResponse.setBody("{}")
        mockWebServer.enqueue(mockResponse)

        val response = appApi.getWeather("Pune", units = "imperial", appid = "")
        mockWebServer.takeRequest()
        Assert.assertEquals(null,response.city)
    }

    @Test
    fun testGetWeather_returnResponse(){

    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}