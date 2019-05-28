package com.verifi.ramon.weather.domain


import com.google.gson.annotations.SerializedName

data class Clouds (

	@SerializedName("all") val all : Int
)