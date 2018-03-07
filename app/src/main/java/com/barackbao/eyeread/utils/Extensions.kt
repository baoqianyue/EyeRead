package com.barackbao.eyeread.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.Serializable

/**
 * Created by BarackBao on 2018/2/3.
 */


/**
 * 将被观察者派遣到io线程，观察者派遣到主线程的懒人写法
 */
fun <T> Observable<T>.io_main(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
}

fun Context.showToast(content: String) {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
}

fun Fragment.showToast(content: String) {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_SHORT)
    toast.show()
}

inline fun <reified T : Activity> Context.startActivityWithData(data: Serializable) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("data", data)
    startActivity(intent)
}