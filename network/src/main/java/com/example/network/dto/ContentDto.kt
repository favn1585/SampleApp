package com.example.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentDto(
    @Json(name = "color")
    val color: String,
    @Json(name = "text")
    val text: String
)