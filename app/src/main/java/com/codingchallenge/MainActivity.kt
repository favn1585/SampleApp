package com.codingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.codingchallenge.databinding.ActivityMainBinding
import com.codingchallenge.di.appModule
import com.codingchallenge.extensions.TAG
import com.example.network.di.networkModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        setupGraph()
    }

    private fun setupGraph() {
       /* supportFragmentManager.beginTransaction()
            .replace(
                R.id.nav_host,
                NavHostFragment.create(R.navigation.navigation_graph),
                NavHostFragment::class.TAG
            )
            .commitNowAllowingStateLoss()*/
    }
}