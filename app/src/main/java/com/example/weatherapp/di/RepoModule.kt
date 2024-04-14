package com.example.weatherapp.di

import com.example.data.remote.TempApiService
import com.example.data.repo.TempRepoImpl
import com.example.domain.repo.GetTempRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideTempRepo(tempService: TempApiService, city: String): GetTempRepo {
        return TempRepoImpl(tempService, city)
    }
}