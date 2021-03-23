package com.lbnkosi.weatherapp.features.base

import androidx.appcompat.app.AppCompatActivity
import com.lbnkosi.weatherapp.core.util.DialogUtils
import com.lbnkosi.weatherapp.features.weather.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity: AppCompatActivity() {

    private var dialogUtils: DialogUtils? = null

    fun getDialog(): DialogUtils {
        return when {
            dialogUtils != null -> dialogUtils!!
            else -> DialogUtils(this)
        }
    }

    fun replaceFragment(id: Int): Boolean {
        supportFragmentManager.beginTransaction().apply {
            this.replace(id, WeatherFragment())
            this.commit()
        }
        return true
    }
}