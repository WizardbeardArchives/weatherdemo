package com.verifi.ramon.weather

import com.verifi.ramon.weather.domain.WeatherDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("/data/2.5/weather")
    fun getWeatherByCity(@Query("id") city: Integer,
                         @Query("appId") appId: String,
                         @Query("units") units: String = "imperial") : Call<WeatherDto>
}