package com.example.network.di

import com.example.domain.repository.LessonsRepository
import com.example.network.api.LessonsApi
import com.example.network.repository.LessonsRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://mimochallenge.azurewebsites.net"

val networkModule = module {

    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        retrofit.create(LessonsApi::class.java) as LessonsApi
    }

    single { LessonsRepositoryImpl(get()) as LessonsRepository }
}