package com.example.data.repo

import android.util.Log
import com.example.data.PublicData
import com.example.data.remote.TempApiService
import com.example.domain.repo.GetCityRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProvideCityService {
    private fun getCityService(): TempApiService {
        return Retrofit.Builder().baseUrl(PublicData.baseUrlCity)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(TempApiService::class.java)
    }

    fun getCityRepo(): GetCityRepo {
        return CityRepoImpl(getCityService())
    }
}