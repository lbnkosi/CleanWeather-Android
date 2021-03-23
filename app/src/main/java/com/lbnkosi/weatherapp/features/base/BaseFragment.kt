package com.lbnkosi.weatherapp.features.base

import androidx.fragment.app.Fragment
import com.lbnkosi.weatherapp.core.util.DialogUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private var dialogUtils: DialogUtils? = null

    fun getDialog(): DialogUtils {
        return when {
            dialogUtils != null -> dialogUtils!!
            else -> DialogUtils(requireContext())
        }
    }

}