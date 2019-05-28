package com.verifi.ramon.weather

import com.verifi.ramon.weather.domain.WeatherDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import retrofit2.Call

@Service
class WeatherService {

    @Value("\${openweather.api.key}")
    lateinit var key: String

    @Autowired
    lateinit var weatherRestClient: RestApi

    fun getWeatherForCity(city: String): WeatherDto? {
        try {

            println("Attempting to retrieve weather for city: $city...")

            val result: Call<WeatherDto> = weatherRestClient.getWeatherByCity(city, key)

            println("Retrieved weather for city: $city with result: $result")

            return result.execute().body() as WeatherDto
        } catch (ex: Exception) {
            println("Error retrieving weather for city: $city with message: ${ex.message}")
            ex.printStackTrace()
        }

        return null
    }

}