package com.example.domain.repository

import com.example.domain.entity.Lessons

interface LessonsRepository {
    suspend fun getLessons(): Lessons
}