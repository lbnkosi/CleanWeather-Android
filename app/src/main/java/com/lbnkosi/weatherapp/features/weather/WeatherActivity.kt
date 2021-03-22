package com.lbnkosi.weatherapp.features.weather

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationTokenSource
import com.lbnkosi.weatherapp.R
import com.lbnkosi.weatherapp.core.commons.Constants.REQ_CODE_SETTINGS
import com.lbnkosi.weatherapp.databinding.ActivityWeatherBinding
import com.lbnkosi.weatherapp.features.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class WeatherActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {

    companion object {
        const val RC_LOCATION = 124
    }

    private lateinit var mBinding: ActivityWeatherBinding

    private val mViewModel: WeatherViewModel by viewModels()

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        configureLocationPermission()
    }

    /**
     * IF DEFAULT_SETTINGS_REQ_CODE : This will call the configureLocationPermission which checks permissions
     * If REQ_CODE_SETTINGS: This will call the configureLocationService which checks for GPS
     */

    //TODO remove deprecated method replace with ->
    // https://proandroiddev.com/is-onactivityresult-deprecated-in-activity-results-api-lets-deep-dive-into-it-302d5cf6edd
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) configureLocationPermission()
        if (requestCode == REQ_CODE_SETTINGS) configureLocationService()
    }

    /**
     * ? What does this callback do ? We implement it but we don't do anything
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    /**
     * When permissions have been granted we call the configureLocationPermission function
     */
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        configureLocationPermission()
    }

    /**
     * If the user permissions are denied we show a dialog requesting the permissions as the app won't work without them
     * If the user still doesn't grant them we take them to the settings screen
     */
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        AppSettingsDialog.Builder(this).build().show()
    }

    /**
     * We check if the user has granted us location permissions. If not we request that they do
     * If location permissions are granted we call the configureLocationService function
     */
    private fun configureLocationPermission() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION)) configureLocationService()
        else EasyPermissions.requestPermissions(this, getString(R.string.location_required), RC_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    }

    /**
     * If the user turned off the GPS we call the enableGPS function else we resume with retrieving the current location
     */
    private fun configureLocationService() {
        if (!(getSystemService(LOCATION_SERVICE) as LocationManager).isProviderEnabled(LocationManager.GPS_PROVIDER)) enableGps()
        else retrieveCurrentLocation()
    }

    /**
     * By the time we call this method, we have already checked for location and gps permissions
     * This method retrieves a users current location.
     */
    @SuppressLint("MissingPermission")
    private fun retrieveCurrentLocation() {
        val cancellationTokenSource = CancellationTokenSource()
        val cancellationToken = cancellationTokenSource.token
        fusedLocationClient.getCurrentLocation(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, cancellationToken).addOnSuccessListener {
            mViewModel.setLatLng(LatLng(it.latitude, it.longitude))
            replaceFragment(mBinding.frameLayout.id)
        }
    }

    /**
     * This function requests a user to enable GPS as without GPS the app cannot work.
     */
    private fun enableGps() {
        getDialog().showDialog(getString(R.string.gps_not_enabled), getString(R.string.enable_gps), getString(R.string.cancel))
        { _, _ -> startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), REQ_CODE_SETTINGS) }
    }
}