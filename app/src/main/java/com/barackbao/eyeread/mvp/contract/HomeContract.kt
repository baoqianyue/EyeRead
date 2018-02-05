package com.barackbao.eyeread.mvp.contract

import com.barackbao.eyeread.mvp.base.BasePresenter
import com.barackbao.eyeread.mvp.base.BaseView
import com.barackbao.eyeread.mvp.model.bean.HomeBean
import com.barackbao.eyeread.mvp.model.bean.Item

/**
 * Created by BarackBao on 2018/2/5.
 * 主页契约类
 */

class HomeContract {

    interface CHomeView : BaseView<CHomePresenter> {
        fun setFirstData(homeBean: HomeBean)
        fun setMoreData(itemList: ArrayList<Item>)
        fun onError()
    }

    interface CHomePresenter : BasePresenter {

        /**
         * 第一次请求数据或者刷新数据
         */
        fun getFirstData()

        /**
         * 获取更多数据
         */
        fun getMoreData()
    }

}