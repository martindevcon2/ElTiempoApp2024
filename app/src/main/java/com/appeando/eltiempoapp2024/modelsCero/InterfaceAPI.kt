package com.appeando.eltiempoapp2024.Models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//BaseURL = "https://api.openweathermap.org/data/2.5/"

interface InterfaceAPI {
    @GET("weather?")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") appid: String
    ): Call<WeatherApp>

}