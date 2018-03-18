package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.CategoryContract
import com.barackbao.eyeread.mvp.contract.CategoryListContract
import com.barackbao.eyeread.mvp.model.CategoryDetailModel
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.mvp.model.bean.Issue

/**
 * Created by 22876 on 2018/3/18.
 */
class CategoryListPresenter(view: CategoryListContract.CLView) : CategoryListContract.CLPresenter {

    val categoryListView: CategoryListContract.CLView

    val categoryContent: CategoryDetailModel by lazy { CategoryDetailModel() }

    var nextPageUrl = ""

    init {
        categoryListView = view
    }


    override fun firstLoadData(category: Category) {
        categoryListView.setHeader(category)
        categoryContent.loadData(category.id)
                .subscribe({ t: Issue ->
                    nextPageUrl = t.nextPageUrl
                    categoryListView.setListData(t.itemList)
                }, {
                    it.printStackTrace()
                    categoryListView.onError()
                })
    }

    override fun getMoreData() {
        categoryContent.loadMoreData(nextPageUrl)
                .subscribe({ t: Issue ->
                    nextPageUrl = t.nextPageUrl
                    categoryListView.setListData(t.itemList)
                }, {
                    it.printStackTrace()
                    categoryListView.onError()
                })
    }

}