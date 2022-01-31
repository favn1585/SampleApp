package com.codingchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingchallenge.usecases.GetLessonsUseCase
import com.example.domain.entity.Lesson
import com.example.domain.repository.LessonsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getLessonsUseCase: GetLessonsUseCase
): ViewModel() {

    val lessons = MutableStateFlow<List<Lesson>?>(null)

    init {
        viewModelScope.launch {
            lessons.value = getLessonsUseCase.invoke().lessons
        }
    }

    init {

    }
}