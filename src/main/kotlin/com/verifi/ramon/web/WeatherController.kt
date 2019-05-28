package com.verifi.ramon.web

import com.google.gson.Gson
import com.verifi.ramon.weather.WeatherService
import com.verifi.ramon.weather.domain.WeatherDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController {

    @Autowired
    lateinit var weatherService: WeatherService

    @Value("\${openweather.api.lax}")
    lateinit var laxCityCode: Integer // We can't inject kotlin.Int =(

    @GetMapping("/api/v1/weather/lax")
    fun getLosAngelesWeather() : WeatherDto? {

        try {

            println("Attempting to get weather for LAX...")

            val result = weatherService.getWeatherForCity(laxCityCode)

            println("Serializing and returning weather DTO: $result")

            return result

        } catch (ex: Throwable) {
            println("Error calling Weather API: ${ex.message}")
            ex.printStackTrace()
        }

        return null
    }
}