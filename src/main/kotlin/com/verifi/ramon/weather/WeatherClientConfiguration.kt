package com.verifi.ramon.weather

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
open class WeatherClientConfiguration {

    @Value("\${openweather.api.baseUrl}")
    lateinit var baseUrl: String

    @Bean
    open fun weatherRestClient(): RestApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RestApi::class.java)
    }
}