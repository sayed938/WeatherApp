package com.example.weatherapp.ui.viewmodels

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.cityusecase.RecentCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Vector
import javax.inject.Inject


@HiltViewModel
class RecentCityVM @Inject constructor(
    private val shared: SharedPreferences,
    private val recentUseCase: RecentCityUseCase
) : ViewModel() {
    private val _recent: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val newRecent: StateFlow<List<String>> = _recent
    private val editor = shared.edit()

     fun getCities() {
        viewModelScope.launch {
            Log.d("sa-favv",recentUseCase().size.toString())
            _recent.value=recentUseCase()
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