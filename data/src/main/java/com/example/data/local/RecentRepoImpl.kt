package com.example.data.local

import android.content.SharedPreferences
import android.util.Log
import com.example.domain.repo.cityrepo.GetRecentCityRepo
import java.util.Vector


class RecentRepoImpl(private val shared: SharedPreferences) : GetRecentCityRepo {

    private val recentCityUpdate: Vector<String> =Vector<String>()

    init {
        convertMap()
        Log.d("sa-data",shared.all.toString())
    }

    private fun convertMap() {
        val allEntries: Map<String, *> = shared.all
        for ((key, value) in allEntries) {
            recentCityUpdate.add(value.toString())
        }
    }

    override suspend fun getRecentCities(): Vector<String> =recentCityUpdate
}