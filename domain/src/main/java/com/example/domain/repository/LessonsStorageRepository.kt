package com.example.domain.repository

import com.example.domain.entity.Lessons

interface LessonsStorageRepository {
    suspend fun getLessons(): Lessons
}