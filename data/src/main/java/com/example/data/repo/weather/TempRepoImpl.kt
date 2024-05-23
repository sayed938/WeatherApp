package com.example.data.repo.weather

import com.example.data.PublicData
import com.example.data.remote.TempApiService
import com.example.domain.entity.remote.weather.WeatherModel
import com.example.domain.repo.weatherrepo.GetTempRepo

class TempRepoImpl(private val tempService:TempApiService,private val city:String): GetTempRepo {
    override suspend fun getTempRepo(): WeatherModel =tempService.getTempRemotely(PublicData.apiKey, city,5)
}