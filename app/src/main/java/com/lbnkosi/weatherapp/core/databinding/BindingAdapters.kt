package com.lbnkosi.weatherapp.core.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lbnkosi.weatherapp.core.adapters.WeatherForecastAdapter
import com.lbnkosi.weatherapp.core.extensions.filter
import com.lbnkosi.weatherapp.core.models.presenter.UIWeatherForecast
import com.lbnkosi.weatherapp.core.models.resource.Resource

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("setSwipeToRefreshLoading")
    fun setSwipeToRefreshLoading(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = isRefreshing
    }

    @JvmStatic
    @BindingAdapter("bindRecyclerViewAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, response: Resource<UIWeatherForecast>) {
        recyclerView.adapter = WeatherForecastAdapter()
        (recyclerView.adapter as WeatherForecastAdapter).replace(response.data?.list?.filter())
    }

}