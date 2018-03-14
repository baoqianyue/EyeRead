package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView

/**
 * Created by BarackBao on 2018/3/13.
 * 首页自定义textView，显示视频发布日期
 */
class HomeHeaderTextView : FrameLayout {

    val textView by lazy { TextView(context) }

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        textView.gravity = Gravity.CENTER
        textView.textSize = 20f
        textView.typeface = Typeface.createFromAsset(context?.assets, "fonts/Mina_Regular.ttf")
        val paint = textView.paint
        paint.isFakeBoldText = true
        textView.setTextColor(Color.BLACK)
        addView(textView)
    }

    fun setHeaderText(text: String?) {
        textView.setText(text)
    }
}