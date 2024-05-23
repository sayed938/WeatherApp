package com.example.domain.usecase.cityusecase

import com.example.domain.repo.cityrepo.GetCityRepo

class CityUseCase(private val getCity: GetCityRepo) {
    suspend operator fun invoke() = getCity.getAllCities()
}