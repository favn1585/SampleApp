package com.codingchallenge.app

import android.app.Application
import com.codingchallenge.di.appModule
import com.example.local.di.localStorageModule
import com.example.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
            modules(localStorageModule + networkModule + appModule)
        }
    }
}