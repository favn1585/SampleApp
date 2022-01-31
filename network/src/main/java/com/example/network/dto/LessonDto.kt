package com.example.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LessonDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "content")
    val content: List<ContentDto>,
    @Json(name = "input")
    val input: InputDto?
)