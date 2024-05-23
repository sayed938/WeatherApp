package com.example.weatherapp.di.city

import com.example.domain.repo.cityrepo.GetRecentCityRepo
import com.example.domain.usecase.cityusecase.RecentCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RecentCityModule {
    @Provides
    fun provideRecentUseCase(recentRepo: GetRecentCityRepo):RecentCityUseCase{
        return RecentCityUseCase(recentRepo)
    }
}