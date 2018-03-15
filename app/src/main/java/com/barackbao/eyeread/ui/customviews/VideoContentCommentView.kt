package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.barackbao.eyeread.R

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentCommentView : RelativeLayout{
    constructor(context:Context?):this(context,null)
    constructor(context: Context?,attrs:AttributeSet?):this(context,attrs)
    constructor(context: Context?,attrs: AttributeSet?,defStyle:Int):super(context,attrs,0){
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.layout_video_comment,this)

    }
}