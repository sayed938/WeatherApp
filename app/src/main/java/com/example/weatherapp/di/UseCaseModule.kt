package com.example.weatherapp.di

import com.example.domain.repo.GetTempRepo
import com.example.domain.usecase.TempUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCaseTemp(getTempRepo: GetTempRepo): TempUseCase {
        return TempUseCase(getTempRepo)
    }
}