package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.HomeContract
import com.barackbao.eyeread.mvp.model.HomeModel

/**
 * Created by 22876 on 2018/3/5.
 */
class HomePresenter(view: HomeContract.CHomeView) : HomeContract.CHomePresenter {

    //持有view
    val homeView: HomeContract.CHomeView

    init {
        homeView = view
    }

    var nextPageUrl: String? = null
    //持有model
    val homeModel: HomeModel by lazy {
        HomeModel()
    }


    override fun getFirstData() {

    }

    override fun getMoreData() {
    }

}