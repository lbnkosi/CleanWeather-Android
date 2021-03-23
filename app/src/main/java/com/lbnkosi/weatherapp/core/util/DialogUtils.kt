package com.lbnkosi.weatherapp.core.util

import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import com.lbnkosi.weatherapp.R

class DialogUtils(aContext: Context) {

    private val resources: Resources = aContext.resources

    private val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(aContext, R.style.AboutMeDialogTheme)

    fun showDialog(aMessage: String?, aPositiveActionText: String?, aNegativeActionText: String?, aPositiveOnClickListener: DialogInterface.OnClickListener?) {
        if (TextUtils.isEmpty(aMessage) || aPositiveOnClickListener == null) return
        dialogBuilder.setMessage(aMessage)
        dialogBuilder.setPositiveButton(if (TextUtils.isEmpty(aPositiveActionText)) resources.getString(R.string.okay_text) else aPositiveActionText, aPositiveOnClickListener)
        dialogBuilder.setMessage(aMessage).setNegativeButton(if (TextUtils.isEmpty(aNegativeActionText)) resources.getString(R.string.cancel) else aNegativeActionText) { _, _ -> }
        val alertDialog = dialogBuilder.create()
        if (alertDialog.window != null) alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }
}