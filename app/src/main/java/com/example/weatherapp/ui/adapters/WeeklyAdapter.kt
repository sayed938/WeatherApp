package com.example.weatherapp.ui.adapters

import android.R.attr.data
import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.remote.Day
import com.example.domain.entity.remote.ForecastDay
import com.example.weatherapp.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt


class WeeklyAdapter(private var lsWeekly: List<ForecastDay>) :
    RecyclerView.Adapter<WeeklyAdapter.ViewHolderHour>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHour =
        ViewHolderHour(
            LayoutInflater.from(parent.context).inflate(R.layout.next_days_custom, parent, false)
        )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolderHour, position: Int) {
        val day = lsWeekly[position]
        holder.apply {
            insertData(
                day.date,
                day.day.condition.icon,
                day.day.mintemp_c,
                day.day.maxtemp_c,
                day.day.avghumidity
            )
        }
    }

    override fun getItemCount(): Int = lsWeekly.size
    class ViewHolderHour(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var day: TextView = itemView.findViewById(R.id.weekly_day)
        private var conditionImg: ImageView = itemView.findViewById(R.id.weekly_img)
        private var humidity: TextView = itemView.findViewById(R.id.weekly_humidity)
        private var minTemp: TextView = itemView.findViewById(R.id.next_day_min_temp)
        private var maxTemp: TextView = itemView.findViewById(R.id.next_day_max_temp)


        @SuppressLint("SetTextI18n")
        fun insertData(
            day: String,
            img: String,
            minTemp: Double,
            maxTemp: Double,
            humidity: Int
        ) {
            try {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                val date: Date = sdf.parse(day)!!
                sdf.applyPattern("EEEE")
                this.day.text = sdf.format(date)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            this.humidity.text = "$humidity%"
            this.maxTemp.text = "${maxTemp.roundToInt()}º"
            this.minTemp.text = "${minTemp.roundToInt()}º"
            Picasso.get().load("https:$img").into(conditionImg)
        }
    }
}