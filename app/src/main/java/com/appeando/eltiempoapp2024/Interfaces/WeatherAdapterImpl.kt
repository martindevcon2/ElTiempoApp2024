package com.appeando.eltiempoapp2024.Interfaces

import com.appeando.eltiempoapp2024.Models.WeatherApp
import com.appeando.eltiempoapp2024.databinding.ActivityMainBinding

class WeatherAdapterImpl(private val binding: ActivityMainBinding) : WeatherAdapter {

    // Actualiza otros elementos de la vista con los datos del clima
    override fun setData(weatherData: WeatherApp) {
        val temperature = weatherData.main.temp - 273.15
        binding.txtViewTemp.text = "${temperature.toInt()} °C"
    }
}