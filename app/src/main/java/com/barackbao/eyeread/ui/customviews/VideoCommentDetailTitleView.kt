package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import kotlinx.android.synthetic.main.layout_video_comment.view.*
import kotlinx.android.synthetic.main.layout_video_comment_detail_title.view.*

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoCommentDetailTitleView : TextView {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.layout_video_comment_detail_title, null)
        this.comment_title_tv.textSize = 35f
    }

    fun setText(item: Item?) {
        var result = ""
        item?.data?.text
                ?.split("")
                ?.filter { it != "" }
                ?.forEach { result = result + it + "  " }
        this.comment_title_tv.text = result
    }
}