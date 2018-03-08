package com.barackbao.eyeread.ui.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.HomeContract
import com.barackbao.eyeread.mvp.model.bean.HomeBean
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.mvp.presenter.HomePresenter
import com.barackbao.eyeread.ui.adapter.HomeAdapter
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.tabsId
import com.barackbao.eyeread.ui.customviews.PullRefreshRecyclerView
import com.barackbao.eyeread.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by BarackBao on 2018/2/4.
 */
class HomeFragment : BaseFragment(tabId = tabsId[0]), HomeContract.CHomeView {

    //持有persenter
    var persenter: HomePresenter

    init {
        persenter = HomePresenter(this)
    }

    val simpleDateFormat by lazy { SimpleDateFormat("- MMM. dd, 'Brunch' -", Locale.ENGLISH) }

    val homeAdapter: HomeAdapter by lazy { HomeAdapter() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        //设置toolbar字体

        home_rv.adapter = homeAdapter
        home_rv.layoutManager = LinearLayoutManager(activity)
        home_rv.setOnRefreshListener(object : PullRefreshRecyclerView.OnRefreshListener {
            override fun onRefresh() {
                persenter.getFirstData()
            }

        })

    }


    override fun setPresenter(presenter: HomeContract.CHomePresenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFirstData(homeBean: HomeBean) {
        homeAdapter.itemList = homeBean.issueList[0].itemList
    }

    override fun setMoreData(itemList: ArrayList<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        showToast("网络错误")
    }

}