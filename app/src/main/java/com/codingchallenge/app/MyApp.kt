package com.codingchallenge.app

import android.app.Application
import com.codingchallenge.di.appModule
import com.example.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(networkModule + appModule)
        }
    }
}