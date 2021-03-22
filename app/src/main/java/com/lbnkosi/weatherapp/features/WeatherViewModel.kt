package com.lbnkosi.weatherapp.features

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvt.weatherapp.core.models.display.WeatherDisplay
import com.google.android.gms.maps.model.LatLng
import com.lbnkosi.domain.usecase.WeatherUseCase
import com.lbnkosi.weatherapp.R
import com.lbnkosi.weatherapp.core.commons.Constants.UNIT_METRIC
import com.lbnkosi.weatherapp.core.extensions.shouldFetch
import com.lbnkosi.weatherapp.core.extensions.showSnackbar
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

    val weatherDisplay: LiveData<WeatherDisplay?>?
        get() = _weatherDisplay

    val weatherResult: LiveData<Resource<UIWeatherForecast>?>?
        get() = _weatherResult

    private var _isError: MutableLiveData<Boolean> = MutableLiveData(false)

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)

    private var _weatherDisplay: MutableLiveData<WeatherDisplay?>? = MutableLiveData(WeatherDisplay())

    private var _weatherResult: MutableLiveData<Resource<UIWeatherForecast>?>? = MutableLiveData(Resource.loading(null))

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

    private fun updateWeatherDisplay(uiWeatherHolder: UIWeatherForecast) {
        _weatherDisplay?.value = WeatherDisplayMapper().toCurrentWeatherDisplay(uiWeatherHolder.list[0])
    }

    private fun fetchForecast(aIsOffline: Boolean = false) {
        _isLoading.value = true
        _isError.value = false
        viewModelScope.launch {
            mWeatherUseCase.getWeatherForecast(aIsOffline, mLatitude.toString(), mLongitude.toString(), UNIT_METRIC).collect {
                if (it.toPresenter().resourceStatus == ResourceStatus.SUCCESS) {
                    _weatherResult!!.value = it.toPresenter()
                    updateWeatherDisplay(it.toPresenter().data!!)
                } else {
                    _weatherResult!!.value = it.toPresenter()
                    _isError.value = true
                }
            }
            _isLoading.value = false
        }
    }

    init {
        fetch()
    }
}