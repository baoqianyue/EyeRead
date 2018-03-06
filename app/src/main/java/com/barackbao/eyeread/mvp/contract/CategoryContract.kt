package com.barackbao.eyeread.mvp.contract

import com.barackbao.eyeread.mvp.base.BasePresenter
import com.barackbao.eyeread.mvp.base.BaseView
import com.barackbao.eyeread.mvp.model.bean.Category

/**
 * Created by 22876 on 2018/3/5.
 */
interface CategoryContract {
    interface CView : BaseView<CPresenter> {
        fun showCategory(category: ArrayList<Category>)
        fun onError()
    }

    interface CPresenter : BasePresenter {
        fun getData()
    }
}