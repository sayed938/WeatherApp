package com.example.domain.repo

import com.example.domain.entity.remote.WeatherModel

interface GetTempRepo {
    suspend fun getTempRepo(): WeatherModel
}