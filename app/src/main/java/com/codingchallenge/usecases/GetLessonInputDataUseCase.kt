package com.codingchallenge.usecases

import com.codingchallenge.view.model.InputData
import com.example.domain.entity.Lesson

class GetLessonInputDataUseCase {
    fun invoke(lesson: Lesson): InputData? = lesson.input?.let { input ->
        val answerText = lesson.content.joinToString(separator = "") { it.text }
        val prefix = answerText.substring(0, input.startIndex)
        val suffix = answerText.substring(input.endIndex, answerText.length)

        InputData(
            prefix = prefix,
            suffix = suffix,
            answerText = answerText
        )
    }
}