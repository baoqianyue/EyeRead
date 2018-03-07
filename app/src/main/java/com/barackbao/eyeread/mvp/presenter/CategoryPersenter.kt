package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.CategoryContract
import com.barackbao.eyeread.mvp.model.CategoryModel
import com.barackbao.eyeread.ui.fragment.CategoryFragment

/**
 * Created by 22876 on 2018/3/7.
 */
class CategoryPersenter(view: CategoryContract.CView) : CategoryContract.CPresenter {

    //持有model和view，进行数据的请求设置和显示
    val categoryView: CategoryContract.CView
    val categoryModel by lazy { CategoryModel() }

    init {
        categoryView = view
    }

    /**
     * 请求数据
     */
    override fun getData() {
        categoryModel.loadData()
                .subscribe({ categoryView.showCategory(it) },
                        {
                            it.printStackTrace()
                            categoryView.onError()
                        })
    }

}