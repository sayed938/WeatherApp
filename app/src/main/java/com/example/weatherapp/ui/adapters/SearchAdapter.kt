package com.example.weatherapp.ui.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.remote.cities.City
import com.example.domain.entity.remote.cities.CityItem
import com.example.weatherapp.R
import com.example.weatherapp.ui.ActivitiesIntents
import com.example.weatherapp.ui.activities.MainActivity
import com.example.weatherapp.ui.viewmodels.RecentCityVM
import dagger.hilt.android.qualifiers.ApplicationContext

class SearchAdapter(private val cityLS: List<CityItem>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val city: TextView = itemView.findViewById(R.id.search_cityName)
        val cityCard: CardView = itemView.findViewById(R.id.cityCardView)

        fun clicked(city: String) {
            val intent = Intent(itemView.context, MainActivity::class.java)
            intent.putExtra("city", city)
            intent.putExtra("flag", 1)
            itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_rc_custom, parent, false)
        )
    }

    override fun getItemCount(): Int = cityLS?.size!!
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (cityLS[position].city == null) {
            holder.city.text = "null"
        } else
            holder.city.text = cityLS[position]?.city
        holder.cityCard.setOnClickListener {
            holder.clicked(cityLS[position].city)

        }

    }
}


