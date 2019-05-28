package com.verifi.ramon.web

import com.google.gson.Gson
import com.verifi.ramon.weather.WeatherService
import com.verifi.ramon.weather.domain.WeatherDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController {

    @Autowired
    lateinit var weatherService: WeatherService

    @GetMapping("/api/v1/weather/lax")
    fun getLosAngelesWeather() : WeatherDto? {

        try {

            println("Attempting to get weather for LAX...")

            val result = weatherService.getWeatherForCity("5368361")

            println("Serializing and returning weather DTO: $result")

            return result

        } catch (ex: Throwable) {
            println("Error calling Weather API: ${ex.message}")
            ex.printStackTrace()
        }

        return WeatherDto()
    }
}