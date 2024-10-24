package com.appeando.eltiempoapp2024.Interfaces

import com.appeando.eltiempoapp2024.Models.WeatherApp

interface WeatherPresenter {
    fun getWeatherData(city: String)
    fun showWeatherData(weatherData: WeatherApp)
    fun showError(errorMessage: String)
}
