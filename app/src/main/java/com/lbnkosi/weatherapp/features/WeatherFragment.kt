package com.lbnkosi.weatherapp.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.model.LatLng
import com.lbnkosi.weatherapp.R
import com.lbnkosi.weatherapp.core.extensions.shouldFetch
import com.lbnkosi.weatherapp.core.extensions.showSnackbar
import com.lbnkosi.weatherapp.databinding.FragmentWeatherBinding
import com.lbnkosi.weatherapp.features.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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