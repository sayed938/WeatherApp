package com.example.domain.entity.remote

import kotlinx.coroutines.flow.StateFlow

data class Forecast(
    val forecastday: List<ForecastDay>
)