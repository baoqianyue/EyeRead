package com.barackbao.eyeread.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.HomeContract
import com.barackbao.eyeread.mvp.model.bean.HomeBean
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.mvp.presenter.HomePresenter
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.tabsId
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


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun setPresenter(presenter: HomeContract.CHomePresenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFirstData(homeBean: HomeBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setMoreData(itemList: ArrayList<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}