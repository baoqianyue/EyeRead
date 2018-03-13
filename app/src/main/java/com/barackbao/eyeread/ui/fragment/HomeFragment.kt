package com.barackbao.eyeread.ui.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    val linearLayoutManger by lazy { home_rv.layoutManager as LinearLayoutManager }

    var isLoadingMore = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_home, null)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        persenter.getFirstData()
    }

    private fun initView() {
        //设置toolbar字体
        activity.toolbar_title_tv?.typeface = Typeface.createFromAsset(activity?.assets,
                "fonts/Mina_Regular.ttf")
        val paint = activity.toolbar_title_tv.paint
        paint.isFakeBoldText = true

        home_rv.adapter = homeAdapter
        home_rv.layoutManager = LinearLayoutManager(activity)
        home_rv.setOnRefreshListener(object : PullRefreshRecyclerView.OnRefreshListener {
            override fun onRefresh() {
                persenter.getFirstData()
            }
        })

        home_rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE){ //当手指离开屏幕开始处理事件
                    val childCount = home_rv.childCount
                    val itemCount =home_rv.layoutManager.itemCount
                    val firstItemPosition = (home_rv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (childCount + firstItemPosition == itemCount){
                        //滑动到底部了
                        if (!isLoadingMore){
                            isLoadingMore = true
                            LoadingMore()
                        }
                    }

                }

            }

            //监听是否滑动
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                setUpToolbar()
            }
        })

    }

    private fun LoadingMore() {
        persenter.getMoreData()
    }

    override fun setUpToolbar(): Boolean {
        if (super.setUpToolbar()) {
            true
        }
        val firstAdapterPosition = linearLayoutManger.findFirstVisibleItemPosition()
        if (firstAdapterPosition == 0) { //如果当前是headerview就设置为透明
            activity.toolbar.setBackgroundColor(0x00000000.toInt())
            activity.refresh_img.visibility = View.GONE
            activity.toolbar_title_tv.text = ""
        } else {
            if (homeAdapter.itemList.size > 1) {
                activity.toolbar.setBackgroundColor(0xddffffff.toInt())
                activity.refresh_img.visibility = View.VISIBLE
                activity.refresh_img.setImageResource(R.drawable.ic_action_home_refresh)
                activity.toolbar_title_tv.text = "test"
            }
        }
        return true
    }


    override fun setPresenter(presenter: HomeContract.CHomePresenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFirstData(homeBean: HomeBean) {
        homeAdapter.setHeadViewSize(homeBean.issueList[0].count)
        homeAdapter.itemList = homeBean.issueList[0].itemList
        home_rv.hideLoading()
    }

    override fun setMoreData(itemList: ArrayList<Item>) {
        isLoadingMore = false
        homeAdapter.addData(itemList)
    }

    override fun onError() {
        showToast("网络错误")
        home_rv.hideLoading()
    }

}