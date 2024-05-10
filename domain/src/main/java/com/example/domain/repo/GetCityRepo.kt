package com.example.domain.repo

import com.example.domain.entity.remote.cities.City

interface GetCityRepo {
    suspend fun getAllCities(): City
}