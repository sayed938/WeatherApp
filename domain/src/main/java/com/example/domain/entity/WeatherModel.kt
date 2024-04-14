package com.example.domain.entity

data class WeatherModel(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)