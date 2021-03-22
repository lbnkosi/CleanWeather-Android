package com.lbnkosi.weatherapp.features.base

import androidx.fragment.app.Fragment
import com.lbnkosi.weatherapp.core.util.DialogUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private var mDialogUtils: DialogUtils? = null

    fun getDialog(): DialogUtils {
        return when {
            mDialogUtils != null -> mDialogUtils!!
            else -> DialogUtils(requireContext())
        }
    }

}