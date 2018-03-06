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
    private var mTextSizePercent = 1f

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
        this.textSize = textSize
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(context, attrs)
        setDefaultPercent(context)
        this.textSize = textSize
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttrs(context, attrs)
        setDefaultPercent(context)
        this.textSize = textSize
    }

    var textSizePercent: Float
        get() = mTextSizePercent
        set(value) {
            mTextSizePercent = value
            setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
        }

    fun setTextSizePercent(unit: Int, textSizePercent: Float) {
        mTextSizePercent = textSizePercent
        setTextSize(unit, textSize)
    }

    override fun setTextSize(unit: Int, size: Float) {
        var varSize = size
        varSize = (varSize * mTextSizePercent).toInt().toFloat()
        super.setTextSize(unit, varSize)
    }

    override fun setTextSize(size: Float) {
        //使用px像素计算单位设置字体size
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
        val screenHeight = getScreenHeight(context).toFloat()
        mTextSizePercent = screenHeight / baseScreenHeight
    }

}