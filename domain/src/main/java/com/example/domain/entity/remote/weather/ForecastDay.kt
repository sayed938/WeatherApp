package com.example.domain.entity.remote.weather


data class ForecastDay(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)


