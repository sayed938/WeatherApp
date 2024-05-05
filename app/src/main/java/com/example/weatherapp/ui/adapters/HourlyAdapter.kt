package com.example.weatherapp.ui.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.remote.Hour
import com.example.weatherapp.R
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.math.roundToInt

class HourlyAdapter(private var lsHourly: List<Hour>) :
    RecyclerView.Adapter<HourlyAdapter.ViewHolderHour>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHour =
        ViewHolderHour(
            LayoutInflater.from(parent.context).inflate(R.layout.today_temp_custom, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolderHour, position: Int) {
        val hour = lsHourly[position]
        holder.apply {
            insertData(hour.time, hour.condition.icon, hour.temp_c)
        }
    }

    override fun getItemCount(): Int = lsHourly.size


    class ViewHolderHour(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hour: TextView = itemView.findViewById(R.id.today_time)
        private var conditionImg: ImageView = itemView.findViewById(R.id.conditionImgHourly)
        private var temp: TextView = itemView.findViewById(R.id.today_temp)

        @RequiresApi(Build.VERSION_CODES.O)
        fun insertData(hour: String, img: String, temp: Double) {
            this.hour.text =
                LocalDateTime.parse(hour, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                    .toLocalTime().toString()
            Picasso.get().load("https:$img").into(conditionImg)
            this.temp.text = temp.roundToInt().toString()

        }
    }

}
