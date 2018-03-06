package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.WindowManager
import com.barackbao.eyeread.R

/**
 * Created by 22876 on 2018/3/5.
 */
class PercentTextView : AppCompatTextView {
    private var mTextSizePrecent = 1f

    companion object {
        //默认屏幕高度
        private var baseScreenHeight = 1920

        /**
         * 获取当前设备的高度和宽度
         */
        fun getScreenHeight(context: Context): Int {
            val screenValueManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            return screenValueManager.defaultDisplay.height
        }
    }

    constructor(context: Context) : super(context) {
        setDefaultPercent(context)
        textSize = textSize
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(context, attrs)
        setDefaultPercent(context)
        textSize = textSize
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttrs(context, attrs)
        setDefaultPercent(context)
        textSize = textSize
    }

    override fun setTextSize(unit: Int, size: Float) {
        var textSize = size
        textSize = (textSize * mTextSizePrecent).toInt().toFloat()
        super.setTextSize(unit, textSize)
    }

    override fun setTextSize(size: Float) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    }


    /**
     * 获取attr.xml中定义的属性
     */
    private fun getAttrs(context: Context, attrs: AttributeSet) {
        val typeArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.PrecentTextView)
        //从资源文件中加载属性，第一个参数是引用到属性文件中，如果文件中中没有定义
        //第二个参数是设置默认值
        baseScreenHeight = typeArray.getInt(R.styleable.PrecentTextView_baseScreenHeight, baseScreenHeight)
        //将typedArray回收
        typeArray.recycle()
    }

    private fun setDefaultPercent(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}