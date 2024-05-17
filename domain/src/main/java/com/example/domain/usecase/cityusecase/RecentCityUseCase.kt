package com.example.domain.usecase.cityusecase

import com.example.domain.repo.GetRecentCityRepo

class RecentCityUseCase(val city: GetRecentCityRepo) {
    suspend operator fun invoke() =city.getRecentCities()
}