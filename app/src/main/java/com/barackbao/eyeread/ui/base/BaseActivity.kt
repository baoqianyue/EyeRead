package com.barackbao.eyeread.ui.base

import android.support.v7.app.AppCompatActivity
import android.view.accessibility.AccessibilityEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by BarackBao on 2018/2/3.
 */
abstract class BaseActivity : AppCompatActivity(), RxManager {
    //disposable容器
    protected val disposables = CompositeDisposable()

    //当activity销毁时就清空disposable容器，切断观察者连接
    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    /**
     * 添加disposable
     */
    override fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    /**
     * 删除disposable
     */
    override fun dispose(disposable: Disposable) {
        disposables.remove(disposable)
    }

}