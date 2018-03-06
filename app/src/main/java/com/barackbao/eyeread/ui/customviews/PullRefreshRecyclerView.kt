package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by 22876 on 2018/3/5.
 */
class PullRefreshRecyclerView : RecyclerView {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        overScrollMode = View.OVER_SCROLL_NEVER//设置滑动到边界无弧形阴影
    }


}