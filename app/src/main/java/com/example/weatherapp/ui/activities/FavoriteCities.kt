package com.example.weatherapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.ActivityFavoriteCitiesBinding
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.CityVM
import com.example.weatherapp.ui.IconAnimation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FavoriteCities : AppCompatActivity() {
    val cityViewModel: CityVM by viewModels()
    private lateinit var binding: ActivityFavoriteCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IconAnimation.secondLocationAnimation(binding.iconLocationSearch)
        binding.backToMain.setOnClickListener {
            backToMainIntent(savedInstanceState)
        }
        lifecycleScope.launch {
            cityViewModel.cityFlow.collect {
                withContext(Dispatchers.Main) {

                }
            }
        }
    }

    private fun backToMainIntent(option: Bundle?) {

        ActivitiesIntents.favoriteToMainIntent(this, option)
    }
}