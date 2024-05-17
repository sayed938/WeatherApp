package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.remote.WeatherModel
import com.example.domain.entity.remote.cities.City
import com.example.domain.entity.remote.cities.CityItem
import com.example.domain.usecase.cityusecase.CityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityVM @Inject constructor(private val cityUseCase: CityUseCase) : ViewModel() {
    private val _cityStateFlow: MutableStateFlow<City?> = MutableStateFlow(null)
    val cityFlow: StateFlow<City?> = _cityStateFlow
    init {
        getCity()
    }
    private fun getCity() {
        viewModelScope.launch {
            try {
                _cityStateFlow.value = cityUseCase()
                Log.d("sa-city", cityUseCase().size.toString())


            } catch (e: Exception) {
                Log.d("sa-city", e.message.toString())
            }
        }
    }
}