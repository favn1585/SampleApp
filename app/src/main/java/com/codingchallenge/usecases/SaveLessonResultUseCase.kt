package com.codingchallenge.usecases

import com.example.domain.repository.ResultStorageRepository

class SaveLessonResultUseCase(
    private val resultStorageRepository: ResultStorageRepository
) {
    suspend fun invoke(id: Int, startTime: Long, endTime: Long) = resultStorageRepository.putData(
        id = id,
        startTime = startTime,
        endTime = endTime
    )
}