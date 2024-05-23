package com.example.data.local

import android.content.SharedPreferences
import com.example.domain.repo.cityrepo.GetRecentCityRepo


class RecentRepoImpl(private val shared: SharedPreferences) : GetRecentCityRepo {

    private val recentCityUpdate: MutableList<String> =ArrayList<String>()

    init {
        convertMapToSet()
    }

    private fun convertMapToSet() {
        val allEntries: Map<String, *> = shared.all
        for ((key, value) in allEntries) {
            recentCityUpdate.add(value.toString())
        }
    }

    override suspend fun getRecentCities(): List<String> =recentCityUpdate
}