package com.example.domain.usecase

import com.example.domain.repo.GetTempRepo

class TempUseCase(private val getTempRepo: GetTempRepo) {
    operator fun invoke() = getTempRepo.getTempRepo()
}