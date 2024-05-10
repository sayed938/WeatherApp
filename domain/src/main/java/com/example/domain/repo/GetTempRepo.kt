package com.example.domain.repo

import com.example.domain.entity.remote.WeatherModel
import com.example.domain.entity.remote.cities.City

interface GetTempRepo {
    suspend fun getTempRepo(): WeatherModel

}