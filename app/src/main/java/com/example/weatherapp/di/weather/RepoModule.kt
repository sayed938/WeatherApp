package com.example.weatherapp.di.weather

import com.example.data.remote.TempApiService
import com.example.data.repo.weather.TempRepoImpl
import com.example.domain.repo.weatherrepo.GetTempRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    lateinit var city: String

    @Provides
    fun provideTempRepo(tempService: TempApiService): GetTempRepo {
        return TempRepoImpl(tempService, city)
    }
}