package com.barackbao.eyeread.ui.customviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.barackbao.eyeread.R
import kotlinx.android.synthetic.main.layout_category_header.view.*

/**
 * Created by BarackBao on 2018/3/7.
 */
class CategoryDetailHeaderView : RelativeLayout {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initViews()
    }

    private fun initViews() {
        View.inflate(context, R.layout.layout_category_header, this)
        //设置返回键
        category_detail_back_iv.setOnClickListener { (context as Activity).finish() }
    }




}