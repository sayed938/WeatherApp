package com.example.weatherapp.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.ActivityFavoriteCitiesBinding
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.CityVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FavoriteCities : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backToMain.setOnClickListener {
            ActivitiesIntents.recentToMainIntent(this,savedInstanceState)
        }
        binding.searchBt.setOnClickListener{
            ActivitiesIntents.recentToSearchIntent(this, savedInstanceState)
        }

    }

}