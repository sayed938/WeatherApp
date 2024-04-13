package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IconAnimation.firstLocationAnimation(binding.locationIcon)
        binding.listOfCities.setOnClickListener {
            mainToFavoriteIntent(savedInstanceState)
        }

    }

    private fun mainToFavoriteIntent(option: Bundle?) {
        ActivitiesIntents.mainToFavoriteIntent(this, option)
    }

}