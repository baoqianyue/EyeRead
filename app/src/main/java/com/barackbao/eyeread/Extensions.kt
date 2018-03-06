package com.barackbao.eyeread

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by BarackBao on 2018/3/6.
 */

fun Context.showToast(content: String) {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
}

fun Fragment.showToast(content: String) {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_SHORT)
    toast.show()
}