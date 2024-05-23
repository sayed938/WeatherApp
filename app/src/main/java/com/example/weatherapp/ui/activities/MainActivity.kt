package com.example.weatherapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.remote.weather.ForecastDay
import com.example.domain.entity.remote.weather.Hour
import com.example.domain.entity.remote.weather.WeatherModel
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.di.weather.RepoModule
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.IconAnimation
import com.example.weatherapp.ui.adapters.HourlyAdapter
import com.example.weatherapp.ui.adapters.WeeklyAdapter
import com.example.weatherapp.ui.viewmodels.RecentCityVM
import com.example.weatherapp.ui.viewmodels.TempVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val weatherModel: TempVM by viewModels()
    private val recentCity: RecentCityVM by viewModels()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UnsafeIntentLaunch")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCityName()
        //Intents
        IconAnimation.firstLocationAnimation(binding.locationIcon)
        binding.listOfCities.setOnClickListener {
            mainToFavoriteIntent(savedInstanceState)
        }
        getViews()
    }

    private fun getViews() {
        lifecycleScope.launch {
            weatherModel.tempFlow.collect {
                withContext(Dispatchers.Main) {
                    callViews(it)
                }
            }
        }
    }

    private fun callViews(weather: WeatherModel?) {
        displayCurrentTemp(weather)
        displayCurrentWeather(weather)
        try {
            val obj = weather?.forecast?.forecastday
            weather?.forecast?.forecastday?.get(0)?.let { displayHourlyWeekly(it?.hour!!, obj!!) }
        } catch (e: Exception) {
            Log.d("sa-hour-adapter", weather?.forecast?.forecastday?.get(0)!!.hour.toString())
        }
    }

    private fun getCityName() {
        var cityName = "Cairo"
        cityName = intent.getStringExtra("city").toString()
        if (intent.getIntExtra("flag", 0) == 1) {
            RepoModule.city = cityName
            recentCity.saveCity(cityName)
        } else {
            RepoModule.city = "Cairo"
        }
    }

    private fun mainToFavoriteIntent(option: Bundle?) {
        ActivitiesIntents.mainToRecentIntent(this, option)
    }

    @SuppressLint("SetTextI18n")
    private fun displayCurrentTemp(
        currentWeather: WeatherModel?
    ) {
        if (currentWeather != null) {
            binding.cityName.text = currentWeather.location.name
            binding.progressBar.visibility = View.INVISIBLE
            binding.tempDegree.text =
                "${currentWeather.current.temp_c.roundToInt()}º"
            binding.weatherCondition.text = "${currentWeather.current?.condition?.text}"
            binding.maxTemp.text =
                "${currentWeather.forecast.forecastday.get(0).day.maxtemp_c?.roundToInt()}º"

            binding.minTemp.text =
                "${currentWeather.forecast.forecastday.get(0).day.mintemp_c?.roundToInt()}º"

            binding.tempDegree2.text =
                "${currentWeather.current.feelslike_c.roundToInt()}º"
            binding.sunrise.text = currentWeather.forecast.forecastday.get(0).astro.sunrise
            binding.sunset.text = currentWeather.forecast.forecastday.get(0).astro.sunset
            binding.moonrise.text = currentWeather.forecast.forecastday.get(0).astro.moonrise
            binding.moonset.text = currentWeather.forecast.forecastday.get(0).astro.moonset
        } else
            binding.progressBar.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun displayCurrentWeather(
        currentWeather: WeatherModel?
    ) {
        binding.currentPrecipitation.text =
            currentWeather?.current?.precip_mm?.toInt().toString() + "%"
        binding.currentHumidity.text = currentWeather?.current?.humidity.toString() + "%"
        binding.currentWind.text = currentWeather?.current?.wind_kph.toString() + " kph"

    }

    private fun displayHourlyWeekly(lsHourly: List<Hour>, lsWeekly: List<ForecastDay>) {
        binding.rcTodayTemp.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rcWeekly.layoutManager = LinearLayoutManager(this)
        binding.rcTodayTemp.adapter = HourlyAdapter(lsHourly)
        binding.rcWeekly.adapter = WeeklyAdapter(lsWeekly)
    }
}