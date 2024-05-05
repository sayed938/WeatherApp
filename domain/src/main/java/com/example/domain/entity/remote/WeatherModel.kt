package com.example.domain.entity.remote

data class WeatherModel(
    val current: Current,
    val location: Location,
    val forecast: Forecast
)