package com.barackbao.eyeread.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.barackbao.eyeread.R
import com.barackbao.eyeread.ui.base.BaseActivity
import com.barackbao.eyeread.ui.base.BaseFragment
import com.barackbao.eyeread.ui.base.currentFragment
import com.barackbao.eyeread.ui.base.tabsId
import com.barackbao.eyeread.ui.fragment.CategoryFragment
import com.barackbao.eyeread.ui.fragment.HomeFragment
import com.barackbao.eyeread.ui.fragment.HotFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRadioButton()
    }

    private fun setRadioButton() {
        home_rb.isChecked = true
        chooseFragment(R.id.home_rb)
        //设置radioGroup切换监听
        root_rg.setOnCheckedChangeListener { _, radioId -> chooseFragment(radioId) }
    }

    private fun chooseFragment(radioId: Int) {
        currentFragment = radioId

        val beginTransaction = supportFragmentManager.beginTransaction()

        val fragment: Fragment? = supportFragmentManager.findFragmentByTag(radioId.toString())

        if (fragment == null) {
            when (radioId) {
                R.id.home_rb -> beginTransaction.add(R.id.content_fl, HomeFragment(), radioId.toString())
                R.id.hot_rb -> beginTransaction.add(R.id.content_fl, HotFragment(), radioId.toString())
                R.id.category_rb -> beginTransaction.add(R.id.content_fl, CategoryFragment(), radioId.toString())
            }
        }

        tabsId.forEach { tab ->

            //将当前fr转换成base，方便在下面调用base层的刷新函数
            val curFragment = supportFragmentManager.findFragmentByTag(tab.toString()) as BaseFragment?

            if (tab == radioId) {
                curFragment?.let {
                    //智能转换成basefr
                    curFragment.refreshToolbar()
                    beginTransaction.show(it)
                }
            } else {
                curFragment?.let {
                    beginTransaction.hide(it)
                }
            }
        }

        beginTransaction.commit()
    }

}
