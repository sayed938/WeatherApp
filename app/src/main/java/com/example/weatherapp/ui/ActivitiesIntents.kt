package com.example.weatherapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.weatherapp.ui.activities.FavoriteCities
import com.example.weatherapp.ui.activities.MainActivity
import com.example.weatherapp.ui.activities.SearchCities

object ActivitiesIntents {

    fun mainToRecentIntent(main: MainActivity, option: Bundle?) {
        val intent = Intent(main, FavoriteCities::class.java)
        startActivity(main, intent, option)
    }
    fun recentToMainIntent(favorite: FavoriteCities, option: Bundle?) {
        val intent = Intent(favorite, MainActivity::class.java)
        startActivity(favorite, intent, option)
    }
    fun recentToSearchIntent(recent:FavoriteCities,option: Bundle?){
        startActivity(recent,Intent(recent, SearchCities::class.java),option)
    }

}