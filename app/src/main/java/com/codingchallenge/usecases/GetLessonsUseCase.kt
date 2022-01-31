package com.codingchallenge.usecases

import com.example.domain.repository.LessonsRepository

class GetLessonsUseCase(
    private val lessonsRepository: LessonsRepository
) {
    suspend fun invoke() = lessonsRepository.getLessons()
}