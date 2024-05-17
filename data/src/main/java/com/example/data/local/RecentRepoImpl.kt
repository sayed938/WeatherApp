package com.example.data.local

import android.content.SharedPreferences
import com.example.domain.entity.local.RecentCityModel
import com.example.domain.repo.GetRecentCityRepo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecentRepoImpl(private val shared:SharedPreferences):GetRecentCityRepo {

        private val json = shared.getString("list_key", null)
        private val type = object : TypeToken<List<RecentCityModel?>?>() {}.type!!

    override suspend fun getRecentCities(): Set<RecentCityModel> =Gson().fromJson(json, type)


}