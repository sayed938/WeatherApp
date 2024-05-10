package com.example.weatherapp.di.city

import android.util.Log
import com.example.data.repo.ProvideCityService
import com.example.domain.repo.GetCityRepo
import com.example.domain.usecase.cityusecase.CityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CityModule {
    @Provides
    fun provideCityUseCase():CityUseCase{

        return CityUseCase(ProvideCityService.getCityRepo())
    }
}