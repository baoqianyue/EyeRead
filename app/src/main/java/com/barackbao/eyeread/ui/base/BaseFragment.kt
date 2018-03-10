package com.barackbao.eyeread.ui.base

import android.support.v4.app.Fragment
import com.barackbao.eyeread.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by BarackBao on 2018/2/4.
 */
val tabsId = listOf(R.id.home_rb, R.id.category_rb, R.id.hot_rb)//给每个Fragment都设置了id，在每个fr构造函数中初始化
var currentFragment = R.id.home_rb

abstract class BaseFragment constructor(tabId: Int) : Fragment(), RxManager {
    var tabId = 0 //默认为0，即主页

    init {
        this.tabId = tabId
    }

    protected val disposables = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        disposables.clear()
    }

    override fun dispose(disposable: Disposable) {
        disposables.remove(disposable)
    }

    override fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }


    /**
     * 刷新主页toolbar
     */
    open fun setUpToolbar(): Boolean {
        if (tabId != currentFragment) {
            return true
        }
        return false
    }

}