package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Category
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_category_item.view.*

/**
 * Created by BarackBao on 2018/3/6.
 */
class CategoryItemView : FrameLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_category_item, this)
    }

    /**
     * 加载分类名称和分类图片
     */
    fun setData(category: Category) {
        category_name_tv.text = category.name
        Glide.with(context).load(category.bgPicture).centerCrop().into(category_img)
    }
}