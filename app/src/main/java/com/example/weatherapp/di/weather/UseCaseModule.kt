package com.example.weatherapp.di.weather

import com.example.domain.repo.weatherrepo.GetTempRepo
import com.example.domain.usecase.weatherusecase.TempUseCase
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