package com.codingchallenge.di

import com.codingchallenge.MainActivityViewModel
import com.example.domain.repository.LessonsRepository
import com.example.network.repository.LessonsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

val appModule = module {
    viewModel { MainActivityViewModel(get()) }
}