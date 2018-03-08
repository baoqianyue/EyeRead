package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.HomeContract
import com.barackbao.eyeread.mvp.model.HomeModel
import com.barackbao.eyeread.mvp.model.bean.HomeBean

/**
 * Created by 22876 on 2018/3/5.
 */
class HomePresenter(view: HomeContract.CHomeView) : HomeContract.CHomePresenter {

    //持有view
    val homeView: HomeContract.CHomeView

    init {
        homeView = view
    }
    var bannerHomeBean: HomeBean? = null

    var nextPageUrl: String? = null
    //持有model
    val homeModel: HomeModel by lazy {
        HomeModel()
    }


    override fun getFirstData() {
        homeModel.loadFirstData()
                .flatMap({ homeBean ->
                    //也可以在这里过滤掉banner2，不过在homebanner里做了过滤，就懒得改了
                    bannerHomeBean = homeBean
                    homeModel.loadMoreData(homeBean.nextPageUrl)
                })
                .subscribe({ homeBean ->
                    nextPageUrl = homeBean.nextPageUrl
                    bannerHomeBean!!.issueList[0].count = bannerHomeBean!!.issueList[0].itemList.size//这里记录轮播图的长度，在adapter中用

                    //过滤掉banner2item
                    val newItemList = homeBean.issueList[0].itemList
                    newItemList.filter { item -> item.type == "banner2" }.forEach { item -> newItemList.remove(item)  }

                    bannerHomeBean?.issueList!![0].itemList.addAll(newItemList)
                    homeView.setFirstData(bannerHomeBean!!)
                }, { t ->
                    t.printStackTrace()
                    homeView.onError()
                })

    }

    override fun getMoreData() {
    }

}