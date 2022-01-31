package com.example.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InputDto(
    @Json(name = "startIndex")
    val startIndex: Int,
    @Json(name = "endIndex")
    val endIndex: Int
)