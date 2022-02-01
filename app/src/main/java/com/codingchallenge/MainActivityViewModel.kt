package com.codingchallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingchallenge.usecases.GetLessonInputDataUseCase
import com.codingchallenge.usecases.GetLessonSpanDataUseCase
import com.codingchallenge.usecases.GetLessonsUseCase
import com.codingchallenge.view.model.InputData
import com.codingchallenge.view.model.SpanData
import com.example.domain.entity.Lesson
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getLessonsUseCase: GetLessonsUseCase,
    private val getLessonInputDataUseCase: GetLessonInputDataUseCase,
    private val getLessonSpanDataUseCase: GetLessonSpanDataUseCase
) : ViewModel() {

    val viewState = MutableLiveData(LessonState())
    val inputCorrect = MutableLiveData(false)

    fun init() {
        viewModelScope.launch {
            viewState.value = viewState.value?.copy(
                lessons = getLessonsUseCase.invoke().lessons
            )
            goToNextLesson()
        }
    }

    fun goToNextLesson() {
        inputCorrect.value = false

        val currentLesson = viewState.value?.currentLesson
        val lessons = viewState.value?.lessons ?: listOf()

        val nextLesson = if (currentLesson == null) {
            lessons.firstOrNull()
        } else {
            val currentLessonIndex = lessons.indexOf(currentLesson)
            if (currentLessonIndex < lessons.size) {
                lessons[currentLessonIndex + 1]
            } else {
                null
            }
        }

        viewState.value = viewState.value?.copy(
            currentLesson = nextLesson,
            currentLessonInputData = nextLesson?.let { getLessonInputDataUseCase.invoke(it) },
            currentLessonSpanData = nextLesson?.let { getLessonSpanDataUseCase.invoke(it) }
        )
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (viewState.value?.currentLessonInputData == null ||
            s.toString() == viewState.value?.currentLessonInputData?.answerText
        ) {
            inputCorrect.value = true
        }
    }

    data class LessonState(
        val lessons: List<Lesson> = emptyList(),
        val currentLesson: Lesson? = null,
        val currentLessonInputData: InputData? = null,
        val currentLessonSpanData: List<SpanData>? = null
    ) {
        val hasData: Boolean = currentLesson != null
    }
}