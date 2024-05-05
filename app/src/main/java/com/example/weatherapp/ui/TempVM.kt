package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.remote.WeatherModel
import com.example.domain.usecase.TempUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TempVM @Inject constructor(
    private val tempUseCase: TempUseCase
) : ViewModel() {
    init {
        getTemp()
    }

    private val _tempStateFlow: MutableStateFlow<WeatherModel?> = MutableStateFlow(null)
    val tempFlow: StateFlow<WeatherModel?> = _tempStateFlow
    private fun getTemp() {
        viewModelScope.launch {
            try {
                _tempStateFlow.value = tempUseCase()
                Log.d("sa-vm",tempUseCase().forecast.forecastday.get(0).hour.size.toString())
            } catch (e: Exception) {
                Log.d("sa-vm", e.message.toString())
            }
        }
    }
}