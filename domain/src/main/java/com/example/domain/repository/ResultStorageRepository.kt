package com.example.domain.repository

interface ResultStorageRepository {
    suspend fun putData(id: Int, startTime: Long, endTime: Long)
}