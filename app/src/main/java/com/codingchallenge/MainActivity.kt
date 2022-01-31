package com.codingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingchallenge.di.appModule
import com.example.network.di.networkModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.launch()
    }
}