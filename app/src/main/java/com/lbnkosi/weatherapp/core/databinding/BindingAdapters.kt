package com.lbnkosi.weatherapp.core.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.lbnkosi.weatherapp.core.adapters.ForecastAdapter
import com.lbnkosi.weatherapp.core.extensions.filter
import com.lbnkosi.weatherapp.core.models.presenter.UIWeatherForecast
import com.lbnkosi.weatherapp.core.models.resource.Resource

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(aImageView: ImageView, aUrl: String?) {
        if (!aUrl.isNullOrEmpty()) {
            Glide.with(aImageView.context).load(aUrl).into(aImageView)
        }
    }

    @JvmStatic
    @BindingAdapter("setSwipeToRefreshLoading")
    fun setSwipeToRefreshLoading(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = isRefreshing
    }

    @JvmStatic
    @BindingAdapter("bindRecyclerViewAdapter")
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, response: Resource<UIWeatherForecast>) {
        recyclerView.adapter = ForecastAdapter()
        (recyclerView.adapter as ForecastAdapter).submitList(response.data?.list?.filter())
    }
}