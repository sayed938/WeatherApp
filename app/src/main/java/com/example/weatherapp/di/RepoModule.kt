package com.example.weatherapp.di

import com.example.data.remote.TempApiService
import com.example.data.repo.TempRepoImpl
import com.example.domain.repo.GetTempRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RepoModule{
    @Provides
    fun provideTempRepo (tempService: TempApiService): GetTempRepo {
        return TempRepoImpl(tempService, "cairo")
    }
}