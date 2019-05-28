package com.verifi.ramon.web

import com.verifi.ramon.weather.domain.WeatherDto
import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherControllerTest {

    @LocalServerPort
    lateinit var serverPort: Integer // kotlin.Int can't be injected

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Before
    fun setUp() {
        assertThat(this.serverPort).isNotNull
        assertThat(this.restTemplate).isNotNull
    }

    @Test
    fun getLosAngelesWeather() {
        println("Now testing ::getLosAngelesWeather()...")

        assertThat(this.restTemplate
            .getForObject(
                "http://localhost:$serverPort/api/v1/weather/lax",
                WeatherDto::class.java)).isNotNull

        assertThat(this.restTemplate
            .getForObject(
                "http://localhost:$serverPort/api/v1/weather/lax",
                WeatherDto::class.java)).hasFieldOrPropertyWithValue("name", "Los Angeles")

        assertThat(this.restTemplate
            .getForObject(
                "http://localhost:$serverPort/api/v1/weather/lax",
                WeatherDto::class.java)).hasFieldOrPropertyWithValue("sys.country", "US")
    }
}