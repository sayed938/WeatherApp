package com.example.domain.usecase.cityusecase

import com.example.domain.repo.GetCityRepo
import com.example.domain.repo.GetTempRepo

class CityUseCase(private val getCity: GetCityRepo) {
    suspend operator fun invoke() = getCity.getAllCities()
}