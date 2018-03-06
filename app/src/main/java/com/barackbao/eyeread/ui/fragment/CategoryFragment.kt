package com.barackbao.eyeread.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.CategoryContract
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.showToast
import com.barackbao.eyeread.ui.adapter.CategoryAdapter
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.tabsId

/**
 * Created by 22876 on 2018/3/5.
 */
class CategoryFragment : BaseFragment(tabId = tabsId[1]), CategoryContract.CView {

    private val adapter by lazy { CategoryAdapter() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager = GridLayoutManager(context,2)
        gridLayoutManager.spanSizeLookup = object :GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                if (gridLayoutManager.itemCount - 1 == position)
            }

        }

    }

    override fun setPresenter(presenter: CategoryContract.CPresenter) {
    }


    override fun showCategory(category: ArrayList<Category>) {
        adapter.setData(category)
    }

    override fun onError() {
        showToast("网络连接失败...")
    }

}