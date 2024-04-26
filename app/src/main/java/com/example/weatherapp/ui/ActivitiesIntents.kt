package com.example.weatherapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.weatherapp.ui.activities.FavoriteCities
import com.example.weatherapp.ui.activities.MainActivity

object ActivitiesIntents {

    fun mainToFavoriteIntent(main: MainActivity, option: Bundle?) {
        val intent = Intent(main, FavoriteCities::class.java)
        startActivity(main, intent, option)
    }
    fun favoriteToMainIntent(favorite: FavoriteCities, option: Bundle?) {
        val intent = Intent(favorite, MainActivity::class.java)
        startActivity(favorite, intent, option)
    }

}