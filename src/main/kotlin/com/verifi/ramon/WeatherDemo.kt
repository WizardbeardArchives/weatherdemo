package com.verifi.ramon

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = ["com.verifi.ramon"])
open class WeatherDemo

fun main(args: Array<String>) {
    println("Welcome to WeatherDemo for Verifi!")

    SpringApplication.run(WeatherDemo::class.java, *args)
}

