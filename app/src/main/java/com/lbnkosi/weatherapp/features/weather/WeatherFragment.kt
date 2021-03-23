package com.lbnkosi.weatherapp.features.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.lbnkosi.weatherapp.databinding.FragmentWeatherBinding
import com.lbnkosi.weatherapp.features.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : BaseFragment() {

    private lateinit var binding: FragmentWeatherBinding

    private val viewModel : WeatherViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeToRefresh.setOnRefreshListener(viewModel::fetch)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.fetch()
    }
}