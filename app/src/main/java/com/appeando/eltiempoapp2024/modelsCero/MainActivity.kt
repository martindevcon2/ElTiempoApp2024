package com.appeando.eltiempoapp2024.Models

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import com.appeando.eltiempoapp2024.databinding.ActivityMainBinding
import com.appeando.eltiempoapp2024.Interfaces.WeatherAdapter
import com.appeando.eltiempoapp2024.Interfaces.WeatherAdapterImpl
import com.appeando.eltiempoapp2024.Interfaces.WeatherPresenter
import com.appeando.eltiempoapp2024.Interfaces.WeatherPresenterImpl

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: WeatherPresenter
    private lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureView()
        adapter = WeatherAdapterImpl(binding)
        presenter = WeatherPresenterImpl(this, adapter)
    }
    private fun configureView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
        binding.btnSearchCity.setOnClickListener{
           presenter.getWeatherData(binding.inputCity.text.toString())
        }
    }
    // Implementa los métodos de la interfaz View para actualizar la vista
    fun showWeatherData(weatherData: WeatherApp) {
        // No es necesario hacer nada aquí, ya que el Adapter se encarga de actualizar la vista
    }


    fun showError(errorMessage: String) {
        // Muestra el mensaje de error en la vista, por ejemplo, en un Toast
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }


}