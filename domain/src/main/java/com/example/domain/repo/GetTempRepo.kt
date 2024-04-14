package com.example.domain.repo

import com.example.domain.entity.remote.WeatherModel

interface GetTempRepo {
    fun getTempRepo(): WeatherModel
}