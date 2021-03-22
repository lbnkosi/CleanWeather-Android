package com.lbnkosi.weatherapp.features.base

import androidx.appcompat.app.AppCompatActivity
import com.lbnkosi.weatherapp.core.util.DialogUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity: AppCompatActivity() {

    private var mDialogUtils: DialogUtils? = null

    fun getDialog(): DialogUtils {
        return when {
            mDialogUtils != null -> mDialogUtils!!
            else -> DialogUtils(this)
        }
    }


}