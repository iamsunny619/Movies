package com.example.movies.ui.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.movies.R

object AppUtils {

    @SuppressLint("ObsoleteSdkInt")
    fun setTransparentStatusColor(
        activity: Activity,
        isWhiteText: Boolean,
        color: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            when {
                Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1 -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = ContextCompat.getColor(
                        activity,
                        if (isWhiteText) R.color.transparent else R.color.gray
                    )
                }
                Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = ContextCompat.getColor(activity, color)
                }
                else -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = ContextCompat.getColor(activity, color)
                }
            }
            setSystemBarTheme(
                activity,
                isWhiteText
            )
        }
    }

    fun dpToPx(context: Context?, valueInDp: Float): Float {
        val metrics = context?.resources?.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics)
    }


    private fun setSystemBarTheme(
        pActivity: Activity,
        pIsDark: Boolean
    ) {
        val lFlags = pActivity.window.decorView.systemUiVisibility
        pActivity.window.decorView.systemUiVisibility =
            if (pIsDark) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                lFlags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                TODO("VERSION.SDK_INT < M")
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                lFlags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                TODO("VERSION.SDK_INT < M")
            }
    }
}