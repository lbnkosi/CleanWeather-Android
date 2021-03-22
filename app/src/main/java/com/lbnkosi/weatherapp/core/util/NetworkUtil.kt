package com.lbnkosi.weatherapp.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtil {

    /**
     * https://developer.android.com/training/monitoring-device-state/connectivity-status-type
     * New monitor requires Android 10 so I use the old one
     */
    fun isConnectedOrConnecting(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}