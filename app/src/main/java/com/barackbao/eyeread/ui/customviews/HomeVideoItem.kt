package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.layout_home_video_item.view.*

/**
 * Created by 22876 on 2018/3/11.
 */
class HomeVideoItem : FrameLayout {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_home_video_item, this)
    }

    fun setData(item: Item, type: String) {
        val data = item.data
        var icon = item.data?.author?.icon
        val itemBack = data?.cover?.feed

        if (icon == null) {
            icon = data?.provider?.icon
        }

        Glide.with(context).load(itemBack).centerCrop().into(video_back_img)
        val circleVideoIcon = object : BitmapImageViewTarget(video_img) {
            override fun setResource(resource: Bitmap?) {
                super.setResource(resource)
                val circleBitmap = RoundedBitmapDrawableFactory.create(resources, resource)
                circleBitmap.isCircular = true
                video_img.setImageDrawable(circleBitmap)
            }
        }

        if (icon == null) {
            Glide.with(context).load(R.drawable.barack).asBitmap().centerCrop().into(circleVideoIcon)
        } else {
            Glide.with(context).load(icon).asBitmap().centerCrop().into(circleVideoIcon)
        }

        video_title_tv.setText(item.data?.text)


    }


}