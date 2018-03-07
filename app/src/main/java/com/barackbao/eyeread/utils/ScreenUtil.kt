package com.barackbao.eyeread.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Created by 22876 on 2018/3/7.
 */

class ScreenUtil {

    companion object {
        fun dip2px(dip: Float, context: Context): Int {
            val scale = context.resources.displayMetrics?.density
            return (dip * scale!! + 0.5f).toInt()
        }
    }
}