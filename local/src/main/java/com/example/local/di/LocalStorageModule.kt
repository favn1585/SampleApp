package com.example.local.di

import androidx.room.Room
import com.example.domain.repository.ResultStorageRepository
import com.example.local.repository.ResultStorageRepositoryImpl
import com.example.local.room.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localStorageModule = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java, "example_database")
            .build()
    }

    single { ResultStorageRepositoryImpl(get()) as ResultStorageRepository }
}