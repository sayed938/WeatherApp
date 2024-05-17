package com.example.domain.repo

import com.example.domain.entity.local.RecentCityModel

interface GetRecentCityRepo {
    suspend fun getRecentCities(): Set<RecentCityModel>
}