package com.barackbao.eyeread.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.CategoryContract
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.tabsId

/**
 * Created by 22876 on 2018/3/5.
 */
class CategoryFragment : BaseFragment(tabId = tabsId[1]), CategoryContract.CView {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, null)
    }



    override fun setPresenter(presenter: CategoryContract.CPresenter) {
    }

    override fun showCategory(category: ArrayList<Category>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}