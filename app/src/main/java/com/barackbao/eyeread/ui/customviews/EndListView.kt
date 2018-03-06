package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.barackbao.eyeread.R
import kotlinx.android.synthetic.main.layout_list_end.view.*

/**
 * Created by 22876 on 2018/3/5.
 */
class EndListView : FrameLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.layout_list_end, this)
        //设置字体
        end_list_tv?.typeface = Typeface.createFromAsset(context.assets, "fonts/Mina_Regular.ttf")
    }

    fun setShow(isShow: Boolean) {
        end_list_tv.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}