package com.lbnkosi.weatherapp.features

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.weatherapp.core.models.display.WeatherDisplay
import com.google.android.gms.maps.model.LatLng
import com.lbnkosi.domain.usecase.WeatherUseCase
import com.lbnkosi.weatherapp.core.commons.Constants.UNIT_METRIC
import com.lbnkosi.weatherapp.core.extensions.shouldFetch
import com.lbnkosi.weatherapp.core.mappers.display.WeatherDisplayMapper
import com.lbnkosi.weatherapp.core.mappers.presenter.toPresenter
import com.lbnkosi.weatherapp.core.models.presenter.UIWeatherForecast
import com.lbnkosi.weatherapp.core.models.resource.Resource
import com.lbnkosi.weatherapp.core.models.resource.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    //TODO fix this. Or find alternative
    @ApplicationContext private val application: Context,
    private val mWeatherUseCase: WeatherUseCase,
) : ViewModel() {

    private var mLatitude: Double = 0.0

    private var mLongitude: Double = 0.0

    val isError: LiveData<Boolean>
        get() = _isError

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val weatherDisplay: LiveData<WeatherDisplay>
        get() = _weatherDisplay

    val weatherResult: LiveData<Resource<UIWeatherForecast>>
        get() = _weatherResult

    private var _isError: MutableLiveData<Boolean> = MutableLiveData(false)

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)

    private var _fetchResult: Resource<UIWeatherForecast> = Resource.loading(null)

    private var _weatherDisplay: MutableLiveData<WeatherDisplay> = MutableLiveData(WeatherDisplay())

    private var _weatherResult: MutableLiveData<Resource<UIWeatherForecast>> = MutableLiveData(Resource.loading(null))

    private fun getLatLng(): LatLng {
        return LatLng(mLatitude, mLongitude)
    }

    fun setLatLng(aLatLng: LatLng) {
        mLatitude = aLatLng.latitude
        mLongitude = aLatLng.longitude
    }

    fun fetch() = when {
        shouldFetch(application, getLatLng()) -> fetchForecast()
        else -> fetchForecast(aIsOffline = true)
    }

    private fun configureFetchResult(aResource: Resource<UIWeatherForecast>) {
        _fetchResult = aResource
        if (_fetchResult.resourceStatus == ResourceStatus.SUCCESS) fetchSuccess()
        else fetchError()
    }

    private fun fetchSuccess() {
        _weatherResult.value = _fetchResult
        _weatherDisplay.value = WeatherDisplayMapper().toCurrentWeatherDisplay(_fetchResult.data!!.list[0])
    }

    private fun fetchError() {
        _weatherResult.value = _fetchResult
        _isError.value = true
    }

    private fun fetchForecast(aIsOffline: Boolean = false) {
        initFetch()
        viewModelScope.launch {
            mWeatherUseCase.getWeatherForecast(aIsOffline, mLatitude.toString(), mLongitude.toString(), UNIT_METRIC).collect {
                configureFetchResult(it.toPresenter())
            }
            _isLoading.value = false
        }
    }

    private fun initFetch() {
        _isLoading.value = true
        _isError.value = false
    }

    init {
        fetch()
    }
}