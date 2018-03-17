package com.barackbao.eyeread.ui.fragment

import android.graphics.Color
import android.graphics.Rect
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.CategoryContract
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.mvp.presenter.CategoryPersenter
import com.barackbao.eyeread.ui.adapter.CategoryAdapter
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.tabsId
import com.barackbao.eyeread.utils.ScreenUtil
import com.barackbao.eyeread.utils.showToast
import com.barackbao.eyeread.utils.startActivityWithData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by 22876 on 2018/3/5.
 */
class CategoryFragment : BaseFragment(tabId = tabsId[1]), CategoryContract.CView {

    private val adapter by lazy { CategoryAdapter() }

    val categoryPersenter: CategoryPersenter

    init {
        categoryPersenter = CategoryPersenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager = GridLayoutManager(context, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (gridLayoutManager.itemCount - 1 == position) {
                    return 2
                }
                return 1
            }
        }

        category_rv.layoutManager = gridLayoutManager
        category_rv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER //消除滑动到边缘出现阴影
        category_rv.adapter = adapter
        //设置每个item的间隔值
        /* category_rv.addItemDecoration(object : RecyclerView.ItemDecoration() {
             override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView, state: RecyclerView.State?) {
                 val position = parent.getChildAdapterPosition(view)
                 //dip转换为像素单位
                 val itemMargin = ScreenUtil.dip2px(4f, context)!!

                 *//*outRect?.set(if (position % 2 == 0) 0 else itemMargin, itemMargin,
                        if (position % 2 == 0) itemMargin else 0, itemMargin)*//*
                outRect?.set(itemMargin, itemMargin, itemMargin, itemMargin)
            }
        })*/

        categoryPersenter.getData()

    }

    override fun setPresenter(presenter: CategoryContract.CPresenter) {
    }


    override fun showCategory(category: ArrayList<Category>) {
        adapter.setData(category)
    }

    override fun onError() {
        showToast("网络连接错误...")
    }

    override fun setUpToolbar(): Boolean {
        if (super.setUpToolbar()) {
            return true
        }
        super.setUpToolbar()
        activity.toolbar.setBackgroundColor(Color.parseColor("#f7dba3"))
        activity.toolbar_title_tv.text = "分类"
        return true
    }

}