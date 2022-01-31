package com.example.domain.entity

data class Lesson(
    val id: Int,
    val content: List<Content>,
    val input: Input?
)