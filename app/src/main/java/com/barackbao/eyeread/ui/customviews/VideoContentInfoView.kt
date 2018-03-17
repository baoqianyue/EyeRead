package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import kotlinx.android.synthetic.main.layout_video_content_info.view.*

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentInfoView : LinearLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.layout_video_content_info, this)
    }

    fun setData(item: Item) {
        this.video_title_tv.typeface = Typeface.createFromAsset(context.assets, "fonts/chinese.ttf")
        this.video_title_tv.text = item.data?.title
        Log.i("SetVideoInfo", item.data?.title)
        this.video_tag_tv.text = "${item.data?.category} / ${item.data?.duration}"
        this.video_desc_tv.text = item.data?.description
    }
}