package com.appeando.eltiempoapp2024.Interfaces

import com.appeando.eltiempoapp2024.Models.InterfaceAPI
import com.appeando.eltiempoapp2024.Models.MainActivity
import com.appeando.eltiempoapp2024.Models.WeatherApp
import com.appeando.eltiempoapp2024.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherPresenterImpl(private val view: MainActivity, private val adapter: WeatherAdapter) :
    WeatherPresenter {


    override fun getWeatherData(city: String) {
        // Lógica para obtener los datos del clima utilizando Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(InterfaceAPI::class.java)


        val response = retrofit.getWeatherData(city, view.getString(R.string.API_Key))


        response.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    showWeatherData(responseBody)
                } else {
                    showError("Error al obtener los datos del clima")
                }
            }


            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                showError("Error en la conexión")
            }
        })
    }


    override fun showWeatherData(weatherData: WeatherApp) {
        adapter.setData(weatherData)
    }


    override fun showError(errorMessage: String) {
        view.showError(errorMessage)
    }
}