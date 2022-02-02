package com.example.local.repository

import com.example.domain.repository.ResultStorageRepository
import com.example.local.room.Database
import com.example.local.room.entity.LessonResultDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResultStorageRepositoryImpl(
    private val database: Database
) : ResultStorageRepository {
    override suspend fun putData(id: Int, startTime: Long, endTime: Long) {
        withContext(Dispatchers.IO) {
            database.lessonResultDao().insert(
                LessonResultDto(
                    id = id,
                    startTime = startTime,
                    endTime = endTime
                )
            )
        }
    }
}