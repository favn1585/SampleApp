package com.example.network.api

import com.example.network.dto.LessonsDto
import retrofit2.http.GET

interface LessonsApi {

    @GET("/api/lessons")
    suspend fun getLessons(): LessonsDto

}