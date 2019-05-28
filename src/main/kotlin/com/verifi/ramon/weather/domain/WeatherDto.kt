package com.verifi.ramon.weather.domain

import com.google.gson.annotations.SerializedName

data class WeatherDto (

    @SerializedName("coord") val coord : Coord? = null,
    @SerializedName("weather") val weather : List<Weather>? = null,
    @SerializedName("base") val base : String? = null,
    @SerializedName("main") val main : Main? = null,
    @SerializedName("wind") val wind : Wind? = null,
    @SerializedName("clouds") val clouds : Clouds? = null,
    @SerializedName("rain") val rain : Rain? = null,
    @SerializedName("dt") val dt : Int? = null,
    @SerializedName("sys") val sys : Sys? = null,
    @SerializedName("id") val id : Int? = null,
    @SerializedName("name") val name : String? = null,
    @SerializedName("cod") val cod : Int? = null
)