package com.example.weatherapp.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.local.RecentCityModel
import com.example.domain.usecase.cityusecase.RecentCityUseCase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecentCityVM @Inject constructor(
    private val editor: SharedPreferences.Editor,
    private val recentUseCase: RecentCityUseCase
) : ViewModel() {
    init {
        getData()
    }

    private lateinit var newLs: MutableLiveData<Set<RecentCityModel?>>
    val _newLs: MutableLiveData<Set<RecentCityModel?>> = newLs
    fun saveData(recent:RecentCityModel) {
        val json = Gson().toJson(recent)
        editor.putString("list_key", json)
        editor.apply()

    }

    fun getData() {
        viewModelScope.launch {
            newLs.value = recentUseCase()
            Log.d("sa-recent", recentUseCase().size.toString())
        }
    }

}