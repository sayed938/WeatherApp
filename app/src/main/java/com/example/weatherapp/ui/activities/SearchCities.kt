package com.example.weatherapp.ui.activities

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.remote.cities.City
import com.example.weatherapp.databinding.ActivitySearchCitiesBinding
import com.example.weatherapp.ui.viewmodels.CityVM
import com.example.weatherapp.ui.adapters.SearchAdapter
import com.example.weatherapp.ui.viewmodels.RecentCityVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SearchCities : AppCompatActivity() {
    private lateinit var binding: ActivitySearchCitiesBinding
    private val cityViewModel: CityVM by viewModels()
    private val recentCity: RecentCityVM by viewModels()
    private lateinit var lsCity: City
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchView.clearFocus()

        binding.searchRc.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            cityViewModel.cityFlow.collect {
                withContext(Dispatchers.Main) {
                    if (it == null) {
                        delay(1000)
                    } else {
                        lsCity = it
                    }

                }
            }
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val newLsCity = lsCity.filter {
                    it.city != null && it.city.toLowerCase().startsWith(newText!!.toLowerCase())
                }
                binding.searchRc.adapter = SearchAdapter(newLsCity)
                return true
            }


        })
    }

}

