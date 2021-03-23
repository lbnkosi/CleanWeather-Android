package com.lbnkosi.weatherapp.core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lbnkosi.weatherapp.core.mappers.display.WeatherDisplayMapper
import com.lbnkosi.weatherapp.core.models.presenter.UICurrentWeather
import com.lbnkosi.weatherapp.databinding.WeatherForecastRowBinding

class ForecastAdapter : ListAdapter<UICurrentWeather, ForecastAdapter.WeatherForecastViewHolder>(Companion) {

    class WeatherForecastViewHolder(val binding: WeatherForecastRowBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<UICurrentWeather>() {
        override fun areItemsTheSame(oldItem: UICurrentWeather, newItem: UICurrentWeather): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: UICurrentWeather, newItem: UICurrentWeather): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastViewHolder {
        LayoutInflater.from(parent.context)
        val binding = WeatherForecastRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherForecastViewHolder, position: Int) {
        holder.binding.weatherDisplay = WeatherDisplayMapper().toWeatherDisplay(getItem(position))
    }
}