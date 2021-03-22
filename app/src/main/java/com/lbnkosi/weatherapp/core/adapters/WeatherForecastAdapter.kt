package com.lbnkosi.weatherapp.core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lbnkosi.weatherapp.R
import com.lbnkosi.weatherapp.core.commons.DataBoundListAdapter
import com.lbnkosi.weatherapp.core.mappers.display.WeatherDisplayMapper
import com.lbnkosi.weatherapp.core.models.presenter.UICurrentWeather
import com.lbnkosi.weatherapp.databinding.WeatherForecastRowBinding


class WeatherForecastAdapter : DataBoundListAdapter<UICurrentWeather, WeatherForecastRowBinding>() {
    override fun createBinding(parent: ViewGroup?): WeatherForecastRowBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent!!.context), R.layout.weather_forecast_row, parent, false)
    }

    override fun bind(binding: WeatherForecastRowBinding, item: UICurrentWeather) {
        binding.weatherDisplay = WeatherDisplayMapper().toCurrentWeatherDisplay(item)
    }

    override fun areItemsTheSame(oldItem: UICurrentWeather, newItem: UICurrentWeather) =
        newItem == oldItem

    override fun areContentsTheSame(oldItem: UICurrentWeather, newItem: UICurrentWeather) =
        newItem.id == oldItem.id
}