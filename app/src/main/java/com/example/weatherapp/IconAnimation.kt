package com.example.weatherapp

import android.widget.ImageView

object IconAnimation {

    fun firstLocationAnimation(icon: ImageView) {
        icon.animate().apply {
            duration = 3000
            rotationXBy(720f)
        }.start()
    }
    fun secondLocationAnimation(icon: ImageView) {
        icon.animate().apply {
            duration = 3000
            rotationYBy(720f)
        }.start()
    }
}