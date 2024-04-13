package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityFavoriteCitiesBinding
import com.example.weatherapp.databinding.ActivityMainBinding

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