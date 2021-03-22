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

    private lateinit var mBinding: FragmentWeatherBinding

    private val mViewModel : WeatherViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentWeatherBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.swipeToRefresh.setOnRefreshListener(mViewModel::fetch)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this
    }
}