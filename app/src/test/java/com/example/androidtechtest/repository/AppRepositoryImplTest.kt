package com.example.androidtechtest.repository

import com.example.androidtechtest.data.model.Weather
import com.example.androidtechtest.data.repository.AppRepositoryImpl
import com.google.gson.Gson
import org.junit.Before

import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppRepositoryImplTest {

    @Mock
    private lateinit var appRepositoryImpl: AppRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }
   val jData = "{\"city\":{\"id\":1259229,\"name\":\"Pune\",\"coord\":{\"lon\":73.8553,\"lat\":18.5196},\"country\":\"IN\",\"population\":9999,\"timezone\":19800},\"cod\":\"200\",\"message\":7.0611526,\"cnt\":7,\"list\":[{\"dt\":1709793000,\"sunrise\":1709774350,\"sunset\":1709817136,\"temp\":{\"day\":83.07,\"min\":66.79,\"max\":91.45,\"night\":76.24,\"eve\":90.55,\"morn\":66.79},\"feels_like\":{\"day\":80.4,\"night\":74.84,\"eve\":86.38,\"morn\":64.26},\"pressure\":1016,\"humidity\":12,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":7.78,\"deg\":53,\"gust\":8.93,\"clouds\":0,\"pop\":0},{\"dt\":1709879400,\"sunrise\":1709860703,\"sunset\":1709903552,\"temp\":{\"day\":88.38,\"min\":70,\"max\":94.41,\"night\":77.07,\"eve\":93.61,\"morn\":70.61},\"feels_like\":{\"day\":84.58,\"night\":75.79,\"eve\":89.06,\"morn\":68.83},\"pressure\":1014,\"humidity\":15,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":10.29,\"deg\":321,\"gust\":16.35,\"clouds\":0,\"pop\":0},{\"dt\":1709965800,\"sunrise\":1709947056,\"sunset\":1709989968,\"temp\":{\"day\":87.44,\"min\":70.45,\"max\":95.02,\"night\":77.94,\"eve\":93.94,\"morn\":71.22},\"feels_like\":{\"day\":83.88,\"night\":76.66,\"eve\":89.42,\"morn\":69.46},\"pressure\":1014,\"humidity\":17,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":9.62,\"deg\":303,\"gust\":14,\"clouds\":1,\"pop\":0},{\"dt\":1710052200,\"sunrise\":1710033409,\"sunset\":1710076384,\"temp\":{\"day\":89.98,\"min\":72.16,\"max\":97.09,\"night\":77.74,\"eve\":95.14,\"morn\":72.16},\"feels_like\":{\"day\":85.93,\"night\":76.24,\"eve\":90.32,\"morn\":70.34},\"pressure\":1015,\"humidity\":14,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":13.89,\"deg\":287,\"gust\":11.43,\"clouds\":4,\"pop\":0},{\"dt\":1710138600,\"sunrise\":1710119761,\"sunset\":1710162799,\"temp\":{\"day\":91.35,\"min\":71.6,\"max\":97.05,\"night\":79.63,\"eve\":96.67,\"morn\":71.6},\"feels_like\":{\"day\":87.04,\"night\":79.63,\"eve\":91.78,\"morn\":69.4},\"pressure\":1016,\"humidity\":11,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"speed\":8.23,\"deg\":359,\"gust\":12.3,\"clouds\":83,\"pop\":0},{\"dt\":1710225000,\"sunrise\":1710206112,\"sunset\":1710249214,\"temp\":{\"day\":91.56,\"min\":73.54,\"max\":97.68,\"night\":77.94,\"eve\":95.81,\"morn\":73.54},\"feels_like\":{\"day\":87.73,\"night\":77.4,\"eve\":91.6,\"morn\":72.19},\"pressure\":1015,\"humidity\":19,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":15.46,\"deg\":307,\"gust\":17.02,\"clouds\":4,\"pop\":0},{\"dt\":1710311400,\"sunrise\":1710292464,\"sunset\":1710335628,\"temp\":{\"day\":89.37,\"min\":72.01,\"max\":95.32,\"night\":76.03,\"eve\":92.21,\"morn\":72.01},\"feels_like\":{\"day\":85.95,\"night\":74.41,\"eve\":87.82,\"morn\":71.08},\"pressure\":1013,\"humidity\":22,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":16.17,\"deg\":315,\"gust\":20.11,\"clouds\":0,\"pop\":0}]}"

    val gson = Gson()
    val wData: Weather = gson.fromJson(jData, Weather::class.java)

//    val mockResponse =
//    @Test
//    fun getWeatherShouldReturnWeather() = runBlocking {
//        val mockWeatherList = listOf(
//            Weather(City(Coord(73.8553,18.5196),"IN",1259229,"Pune",
//                9999,19800),7,"200")
//            )
//        )
//    }
}