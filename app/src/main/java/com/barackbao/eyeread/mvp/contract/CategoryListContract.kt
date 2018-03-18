package com.barackbao.eyeread.mvp.contract

import com.barackbao.eyeread.mvp.base.BasePresenter
import com.barackbao.eyeread.mvp.base.BaseView
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.mvp.model.bean.Item

/**
 * Created by 22876 on 2018/3/18.
 */
interface CategoryListContract {
    interface CLView : BaseView<CLPresenter> {
        fun setHeader(category: Category)
        fun setListData(itemList: ArrayList<Item>)
        fun onError()
    }

    interface CLPresenter : BasePresenter {
        fun getMoreData()
        fun firstLoadData(category: Category)
    }
}