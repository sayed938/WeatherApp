package com.example.data.remote

import com.example.domain.entity.remote.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface TempApiService {
    @GET("/v1/forecast.json")
    suspend fun getTempRemotely(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: Int
    ): WeatherModel
}