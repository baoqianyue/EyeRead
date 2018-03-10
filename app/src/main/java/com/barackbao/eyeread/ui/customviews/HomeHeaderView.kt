package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_home_header.view.*

/**
 * Created by BarackBao on 2018/3/8.
 */
class HomeHeaderView : RelativeLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initViews()
    }

    private fun initViews() {
        View.inflate(context, R.layout.layout_home_header, this)
    }

    /**
     * 设置数据，
     * 可能有bug
     */
    fun setData(datas: ArrayList<Item>?) {
        Glide.with(context).load(R.drawable.barack).into(home_head_img)
        home_banner_name_tv.text = datas!![0].data?.title
        home_banner_description_tv.text = datas!![0].data?.slogan
    }
}