package com.example.weatherapp.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.weatherapp.databinding.ActivityFavoriteCitiesBinding
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.adapters.RecentCitiesAdapter
import com.example.weatherapp.ui.viewmodels.RecentCityVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FavoriteCities : AppCompatActivity() {
    private val recentCity: RecentCityVM by viewModels()
    private lateinit var binding: ActivityFavoriteCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rcRecentCities.layoutManager=LinearLayoutManager(this)
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                recentCity.newRecent.collect {
                  binding.rcRecentCities.adapter= RecentCitiesAdapter(it)
                }
            }
        }

        binding.backToMain.setOnClickListener {
            ActivitiesIntents.recentToMainIntent(this, savedInstanceState)
        }
        binding.searchBt.setOnClickListener {
            ActivitiesIntents.recentToSearchIntent(this, savedInstanceState)
        }

    }

}