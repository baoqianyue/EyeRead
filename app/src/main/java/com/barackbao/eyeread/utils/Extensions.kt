package com.barackbao.eyeread.utils

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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