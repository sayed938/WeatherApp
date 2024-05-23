package com.example.data.repo.city

import com.example.data.remote.TempApiService
import com.example.domain.entity.remote.cities.City
import com.example.domain.repo.cityrepo.GetCityRepo

class CityRepoImpl(private val cityService:TempApiService): GetCityRepo {
    override suspend fun getAllCities(): City =cityService.getCities()
}