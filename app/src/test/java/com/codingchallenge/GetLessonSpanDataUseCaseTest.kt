package com.codingchallenge

import com.codingchallenge.usecases.GetLessonInputDataUseCase
import com.codingchallenge.usecases.GetLessonSpanDataUseCase
import com.example.domain.entity.Content
import com.example.domain.entity.Lesson
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class GetLessonSpanDataUseCaseTest {

    private val useCase = GetLessonInputDataUseCase()

    @Test
    fun `given GetLessonInputDataUseCase when parse data then return proper values`() {
        val content = listOf(
            Content("#FF0000", UUID.randomUUID().toString()),
            Content("#00FF00", UUID.randomUUID().toString()),
            Content("#0000FF", UUID.randomUUID().toString())
        )

        val lesson = Lesson(
            id = 1,
            content = content,
            input = null
        )

        val result = useCase.invoke(lesson)
        assertEquals(result?.answerText, null)
    }
}