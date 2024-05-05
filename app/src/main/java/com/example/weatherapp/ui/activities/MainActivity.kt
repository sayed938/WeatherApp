package com.example.weatherapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.remote.Hour
import com.example.domain.entity.remote.WeatherModel
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.IconAnimation
import com.example.weatherapp.ui.TempVM
import com.example.weatherapp.ui.adapters.HourlyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val weatherModel: TempVM by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IconAnimation.firstLocationAnimation(binding.locationIcon)
        binding.listOfCities.setOnClickListener {
            mainToFavoriteIntent(savedInstanceState)
        }
        lifecycleScope.launch {
            weatherModel.tempFlow.collect {
                withContext(Dispatchers.Main) {

                    callViews(it)

                }

            }
        }
    }

    private suspend fun callViews(weather: WeatherModel?) {
        delay(1000)
        displayCurrentTemp(weather)
        displayCurrentWeather(weather)
        try {
            weather?.forecast?.forecastday?.get(0)?.let { displayHourlyTemp(it.hour) }
        } catch (e: Exception) {
            Log.d("sa-hour-adapter", weather?.forecast?.forecastday?.get(0)!!.hour.toString())
        }
    }

    private fun mainToFavoriteIntent(option: Bundle?) {
        ActivitiesIntents.mainToFavoriteIntent(this, option)
    }

    @SuppressLint("SetTextI18n")
    private fun displayCurrentTemp(
        currentWeather: WeatherModel?
    ) {
        if (currentWeather != null) {
            binding.progressBar.visibility = View.INVISIBLE
            binding.tempDegree.text =
                currentWeather.current?.temp_c?.roundToInt()?.toString() + "º"
            binding.weatherCondition.text = currentWeather.current?.condition?.text.toString()
            binding.maxTemp.text =
                currentWeather.forecast?.forecastday?.get(0)?.day?.maxtemp_c?.roundToInt()
                    .toString() + "º"

            binding.minTemp.text =
                currentWeather.forecast?.forecastday?.get(0)?.day?.mintemp_c?.roundToInt()
                    .toString() + "º"

            binding.tempDegree2.text =
                currentWeather.current?.feelslike_c?.roundToInt()?.toString() + "º"
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

    private fun displayHourlyTemp(lsHourly: List<Hour>) {
        binding.rcTodayTemp.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rcTodayTemp.adapter = HourlyAdapter(lsHourly)
    }

}