package com.example.domain.entity.remote.weather

data class Astro(
    val is_moon_up: Long,
    val is_sun_up: Long,
    val moon_illumination: Long,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)