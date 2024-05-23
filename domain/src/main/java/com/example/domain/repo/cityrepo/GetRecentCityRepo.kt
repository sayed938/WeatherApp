package com.example.domain.repo.cityrepo

interface GetRecentCityRepo {
    suspend fun getRecentCities(): List<String>
}