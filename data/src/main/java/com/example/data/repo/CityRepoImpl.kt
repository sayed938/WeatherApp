package com.example.data.repo

import com.example.data.remote.TempApiService
import com.example.domain.entity.remote.cities.City
import com.example.domain.entity.remote.cities.CityItem
import com.example.domain.repo.GetCityRepo

class CityRepoImpl(private val cityService:TempApiService):GetCityRepo {
    override suspend fun getAllCities(): City =cityService.getCities()
}