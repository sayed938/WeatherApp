package com.example.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class RecentCitiesAdapter(private val recentCitiesList: List<String>) :
    RecyclerView.Adapter<RecentCitiesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityName: TextView = itemView.findViewById(R.id.recentCityName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.city_custom, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int =recentCitiesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text=recentCitiesList[position]
    }
}