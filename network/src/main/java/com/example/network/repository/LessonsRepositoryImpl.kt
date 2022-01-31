package com.example.network.repository

import com.example.domain.entity.Content
import com.example.domain.entity.Input
import com.example.domain.entity.Lesson
import com.example.domain.entity.Lessons
import com.example.domain.repository.LessonsRepository
import com.example.network.api.LessonsApi
import com.example.network.dto.ContentDto
import com.example.network.dto.InputDto
import com.example.network.dto.LessonDto
import com.example.network.dto.LessonsDto

class LessonsRepositoryImpl(
    private val lessonsApi: LessonsApi
) : LessonsRepository {
    override suspend fun getLessons() = lessonsApi.getLessons().toLessons()
}

private fun LessonsDto.toLessons() = Lessons(
    lessons = lessons.map {
        it.toLesson()
    }
)

private fun LessonDto.toLesson() = Lesson(
    id = this.id,
    content = this.content.map {
        it.toContent()
    },
    input = this.input?.toInput()
)

private fun ContentDto.toContent() = Content(
    color = this.color,
    text = this.text
)

private fun InputDto.toInput() = Input(
    startIndex = this.startIndex,
    endIndex = this.endIndex
)