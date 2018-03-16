package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.adapter.VideoCommentAdapter
import kotlinx.android.synthetic.main.layout_video_comment.view.*

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentCommentView : RelativeLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, 0) {
        init()
    }

    val adapter by lazy { VideoCommentAdapter() }

    private fun init() {
        View.inflate(context, R.layout.layout_video_comment, this)
        video_comment_rv.layoutManager = LinearLayoutManager(context)
        video_comment_rv.adapter = adapter
    }

   /* fun setData(items: ArrayList<Item>) {
        adapter.setData(items)
    }

    fun addData(items: ArrayList<Item>) {
        adapter.addData(items)
    }

    fun addData(item: Item) {
        adapter.addData(item)
    }*/
}