package com.codingchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.LessonsRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val lessonsRepository: LessonsRepository
): ViewModel() {

    init {
        launch()
    }

    fun launch() {
        viewModelScope.launch {
            val lessons = lessonsRepository.getLessons()
            var t = 9
            t = 2
        }
    }
}