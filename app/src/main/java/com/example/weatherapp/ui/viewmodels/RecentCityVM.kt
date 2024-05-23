package com.example.weatherapp.ui.viewmodels

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.cityusecase.RecentCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecentCityVM @Inject constructor(
    private val shared: SharedPreferences,
    private val recentUseCase: RecentCityUseCase
) : ViewModel() {
    private val _recent: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val newRecent: StateFlow<List<String>> = _recent
    val editor = shared.edit()

    init {
        getCities()
    }

    private fun getCities() {
        viewModelScope.launch {
            _recent.value = recentUseCase()
        }
    }

    fun saveCity(city: String) {
        editor.putString(city, city)
        editor.apply()
    }

    fun deleteAll() {
        editor.clear()
        editor.apply()
    }

    fun deleteCity(city: String) {
        editor.remove(city)
        editor.apply()
    }

}