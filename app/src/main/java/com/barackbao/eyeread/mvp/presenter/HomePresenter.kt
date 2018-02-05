package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.HomeContract
import com.barackbao.eyeread.mvp.model.HomeModel
import com.barackbao.eyeread.mvp.model.bean.HomeBean

/**
 * Created by BarackBao on 2018/2/5.
 */
class HomePresenter constructor(view: HomeContract.CHomeView) : HomeContract.CHomePresenter {

    var homeView: HomeContract.CHomeView
    var nextPageUrl: String? = null

    init {
        homeView = view
    }

    val homeModel: HomeModel by lazy { HomeModel() }

    var bannerHomeBean: HomeBean? = null


    override fun getFirstData() {
        homeModel.loadFirstData()

    }

    override fun getMoreData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}