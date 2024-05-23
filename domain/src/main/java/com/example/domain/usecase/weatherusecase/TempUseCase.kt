package com.example.domain.usecase.weatherusecase

import com.example.domain.repo.weatherrepo.GetTempRepo

class TempUseCase(private val getTempRepo: GetTempRepo) {
    suspend operator  fun invoke() = getTempRepo.getTempRepo()
}