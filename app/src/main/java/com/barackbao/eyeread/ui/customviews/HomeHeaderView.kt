package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_home_header.view.*
import java.util.*

/**
 * Created by BarackBao on 2018/3/8.
 */
class HomeHeaderView : FrameLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initViews()
    }

    private fun initViews() {
        View.inflate(context, R.layout.layout_home_header, this)
        home_banner_name_tv.typeface = Typeface.createFromAsset(context.assets,
                "fonts/chinese.ttf")
        home_banner_description_tv.typeface = Typeface.createFromAsset(context.assets,
                "fonts/chinese.ttf")
    }

    /**
     * 设置数据，
     * 可能有bug
     */
    fun setData(datas: ArrayList<Item>) {
        datas.filter { item -> item.type == "banner2" }.forEach { item -> datas.remove(item) }
        val random = Random()
        var d = random.nextInt(6)
        val headerItemData = datas!![d]
        Glide.with(context).load(headerItemData.data?.cover?.feed).into(home_head_img)
        home_banner_name_tv.text = headerItemData.data?.title
        home_banner_description_tv.text = headerItemData.data?.slogan
    }
}