package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
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
        video_title_tv.textSize = 40f
        video_title_tv.setTextColor(Color.parseColor("#f7dba3"))
        video_tag_tv.textSize = 35f
        video_tag_tv.setTextColor(Color.parseColor("#f7dba3"))
        video_desc_tv.textSize = 35f
        video_desc_tv.setTextColor(Color.parseColor("#f7dba3"))
    }

    fun setData(item: Item) {
        setTitle(item.data?.title)
        setTags("${item.data?.category} / ${item.data?.duration}")
        setDesc(item.data?.description)
    }

    fun setTitle(title: String?) {
        this.video_title_tv.text = title
    }

    fun setTags(tag: String?) {
        this.video_tag_tv.text = tag
    }

    fun setDesc(desc: String?) {
        this.video_desc_tv.text = desc
    }
}