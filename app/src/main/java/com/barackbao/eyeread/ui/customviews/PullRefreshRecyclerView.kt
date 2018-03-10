package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.barackbao.eyeread.R

/**
 * Created by 22876 on 2018/3/5.
 */
class PullRefreshRecyclerView : RecyclerView {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        overScrollMode = View.OVER_SCROLL_NEVER//设置滑动到边界无弧形阴影
    }

    val pullDistance = 300//下拉达到这个值时，松手才会刷新
    var downY = -1 //down事件发生时的y坐标
    var constY = -1//发生down事件时记录首次手指y坐标，缩放loading时会用到
    var canRefresh = false //是否能刷新
    var isFirstMove = true
    var willRefresh = false //松手后就可刷新
    var homeHeaderView: HomeHeaderView? = null

    var mLastMotionY = 0f
    var deltaY = 0f

    //具体的loadingImageView
    val loading by lazy {
        val loadView = ImageView(context)
        loadView.setImageResource(R.mipmap.eye_loading_progress)
        loadView
    }

    //将loadView包成一个ViewGroup
    val loadingView by lazy {
        val frameLayout = RelativeLayout(context)
        frameLayout.setBackgroundColor(0xaa000000.toInt())
        frameLayout.gravity = Gravity.CENTER
        frameLayout.addView(loading)
        frameLayout.layoutParams = ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT)
        frameLayout
    }


    //将loadingView 放在HeaderView的上面
    var isShow: Boolean = false

    fun showLoading(viewGroup: ViewGroup) {
        isShow = true
        viewGroup.addView(loadingView)
    }

    fun hideLoading() {
        isShow = false
        willRefresh = false
        homeHeaderView?.let { it -> removeView(loadingView) }

    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        var resume = super.onInterceptTouchEvent(e)
        when (e?.action) {
            MotionEvent.ACTION_DOWN -> {
                //down事件发生记录y坐标，后续判断是否可以刷新
                mLastMotionY = e.y
                downY = e.y.toInt()
                constY = e.y.toInt()
                resume = false
            }

            MotionEvent.ACTION_MOVE -> {
                resume = true
            }

            MotionEvent.ACTION_UP -> {
                resume = false
            }
        }
        return resume
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {

        when (e?.action) {
            MotionEvent.ACTION_DOWN -> {
                //记录手指刚触摸屏幕的坐标
                downY = e.y.toInt()
                constY = e.y.toInt()
                if (!this.canScrollVertically(-1) && !willRefresh) {
                    canRefresh = true
                }
            }
            MotionEvent.ACTION_MOVE -> {
                deltaY = e.y
                if (isFirstMove) {
                    isFirstMove = false
                    if (canRefresh) {
                        canRefresh = e.y - downY > 0
                    }
                }

                if (canRefresh) {
                    if (getChildAt(0) is HomeHeaderView) {
                        //在headview上显示loading
                        var loadView = getChildAt(0) as HomeHeaderView
                        if (!isShow) {
                            showLoading(loadView)
                        }

                    }
                }

            }
            MotionEvent.ACTION_UP -> {
                canRefresh = false
                isFirstMove = true
                if (getChildAt(0) is HomeHeaderView) {
                    getChildAt(0)?.let { it -> recover() }
                }
            }
        }



        return super.onTouchEvent(e)
    }


    /**
     * 松手后恢复
     */
    private fun recover() {
        homeHeaderView = getChildAt(0) as HomeHeaderView
        Log.i("PullRefreshRecyclerView", "松手恢复")
        hideLoading()
    }


    interface OnRefreshListener {
        fun onRefresh()
    }

    var onRefreshListner: OnRefreshListener? = null

    fun setOnRefreshListener(listener: OnRefreshListener) {
        this.onRefreshListner = listener
    }

}