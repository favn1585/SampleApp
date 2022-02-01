package com.codingchallenge.usecases

import android.graphics.Color
import com.codingchallenge.view.model.SpanData
import com.example.domain.entity.Lesson

class GetLessonSpanDataUseCase {
    fun invoke(lesson: Lesson): List<SpanData> {
        var lastIndex = 0
        return lesson.content.map {
            SpanData(
                color = Color.parseColor(it.color),
                startIndex = lastIndex,
                endIndex = lastIndex + it.text.length
            ).also { data ->
                lastIndex = data.endIndex
            }
        }
    }
}