package com.verifi.ramon.weather.domain

import com.google.gson.annotations.SerializedName

data class Rain (

    @SerializedName("3h") val `3h` : Int
)