package com.example.weatherapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityFavoriteCitiesBinding
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.IconAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteCities : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IconAnimation.secondLocationAnimation(binding.iconLocationSearch)
        binding.backToMain.setOnClickListener {
            backToMainIntent(savedInstanceState)
        }
    }

    private fun backToMainIntent(option: Bundle?) {
        ActivitiesIntents.favoriteToMainIntent(this, option)
    }
}