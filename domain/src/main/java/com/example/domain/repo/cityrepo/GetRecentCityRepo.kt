package com.example.domain.repo.cityrepo

import java.util.Vector

interface GetRecentCityRepo {
    suspend fun getRecentCities(): Vector<String>
}