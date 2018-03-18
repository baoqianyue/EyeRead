package com.barackbao.eyeread.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.CategoryListContract
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.mvp.presenter.CategoryListPresenter
import com.barackbao.eyeread.mvp.presenter.CategoryPersenter
import com.barackbao.eyeread.ui.adapter.CategoryListAdapter
import com.barackbao.eyeread.ui.base.BaseActivity
import com.barackbao.eyeread.utils.showToast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_category_list.*

/**
 * Created by 22876 on 2018/3/18.
 */
class CategoryListActivity : BaseActivity(), CategoryListContract.CLView {

    //持有presenter
    private lateinit var categoryListPresenter: CategoryListPresenter

    val adapter by lazy { CategoryListAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.getSerializableExtra("data") as Category
        setContentView(R.layout.activity_category_list)
        categoryListPresenter = CategoryListPresenter(this)
        initView()
        categoryListPresenter.firstLoadData(category)
    }

    private fun initView() {
        category_list_rv.layoutManager = LinearLayoutManager(this)
        category_list_rv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        category_list_rv.adapter = adapter

        category_list_rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val childCount = category_list_rv.childCount
                    val itemCount = category_list_rv.layoutManager.itemCount
                    val firstVisibleItem = (category_list_rv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadMore) {
                            loadMore = true
                            onLoadMore()
                        }
                    }
                }
            }
        })
    }

    private fun onLoadMore() {
        categoryListPresenter.getMoreData()
    }

    var loadMore = false
    override fun setPresenter(presenter: CategoryListContract.CLPresenter) {
    }

    override fun setHeader(category: Category) {
        setSupportActionBar(category_toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        val typeface = Typeface.createFromAsset(this.assets, "fonts/chinese.ttf")
        collapsing_toolbar.setCollapsedTitleTypeface(typeface)
        collapsing_toolbar.title = category.name
        Glide.with(this)
                .load(category.headerImage)
                .into(category_img)
    }

    override fun setListData(itemList: ArrayList<Item>) {
        loadMore = false
        adapter.addData(itemList)
    }

    override fun onError() {
        showToast("网络连接错误")
    }

}