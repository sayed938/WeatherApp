package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.remote.WeatherModel
import com.example.domain.usecase.TempUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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
                try {
                    Log.d("sayed-vm1", tempUseCase().forecast.toString())
                }
                catch (e:Exception){
                    Log.d("sayed-vm1", e.message.toString())

                }

            } catch (e: Exception) {
                Log.d("sayed-vm", e.message.toString())
            }
        }
    }
}