package com.example.domain.repo.weatherrepo

import com.example.domain.entity.remote.weather.WeatherModel

interface GetTempRepo {
    suspend fun getTempRepo(): WeatherModel

}