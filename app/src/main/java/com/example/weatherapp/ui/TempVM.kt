package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import com.example.domain.entity.remote.WeatherModel
import com.example.domain.usecase.TempUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TempVM @Inject constructor(
    private val tempUseCase: TempUseCase
) : ViewModel() {
    private val _tempStateFlow: MutableStateFlow<WeatherModel?> = MutableStateFlow(null)
    val tempFlow: StateFlow<WeatherModel?> = _tempStateFlow
    fun getTemp() {

    }
}