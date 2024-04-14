package com.example.domain.entity.remote

data class WeatherModel(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)