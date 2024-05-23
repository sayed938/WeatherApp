package com.example.domain.entity.remote.weather

data class WeatherModel(
    val current: Current,
    val location: Location,
    val forecast: Forecast
)