package com.lbnkosi.weatherapp.core.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.lbnkosi.weatherapp.core.adapters.ForecastAdapter
import com.lbnkosi.weatherapp.core.extensions.filter
import com.lbnkosi.weatherapp.core.models.presenter.WeatherForecast
import com.lbnkosi.weatherapp.core.models.resource.Resource

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("setSwipeToRefreshLoading")
    fun setSwipeToRefreshLoading(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = isRefreshing
    }

    @JvmStatic
    @BindingAdapter("bindRecyclerViewAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, response: Resource<WeatherForecast>) {
        recyclerView.adapter = ForecastAdapter()
        (recyclerView.adapter as ForecastAdapter).submitList(response.data?.list?.filter())
    }
}