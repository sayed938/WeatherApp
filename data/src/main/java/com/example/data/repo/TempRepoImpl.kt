package com.example.data.repo

import com.example.data.remote.TempApiService
import com.example.domain.entity.remote.WeatherModel
import com.example.domain.repo.GetTempRepo
import com.example.weatherapp.PublicData

class TempRepoImpl(private val tempService:TempApiService,private val city:String):GetTempRepo {
    override fun getTempRepo(): WeatherModel =tempService.getTempRemotely(PublicData.apiKey,city,5)
}