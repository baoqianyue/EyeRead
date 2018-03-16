package com.barackbao.eyeread.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.activity.VideoContentActivity
import com.barackbao.eyeread.ui.customviews.HomeHeaderTextView
import com.barackbao.eyeread.ui.customviews.HomeHeaderView
import com.barackbao.eyeread.ui.customviews.HomeVideoItem
import com.barackbao.eyeread.utils.ScreenUtil
import com.barackbao.eyeread.utils.startActivityWithData

/**
 * Created by BarackBao on 2018/3/8.
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val TYPE_HEADERVIEW = 1
    private val TYPE_SIMPLE = 2
    private val TYPE_HEADER_TEXT = 3

    var headViewDataSize = 0

    var itemList: ArrayList<Item> = ArrayList()

    fun setHeadViewSize(size: Int) {
        headViewDataSize = size
    }


    fun addData(itemList: ArrayList<Item>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HEADERVIEW
        }
        if (itemList[position + headViewDataSize - 1].type == "textHeader") {
            return TYPE_HEADER_TEXT
        } else {
            return TYPE_SIMPLE
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        when (viewType) {
            TYPE_HEADERVIEW -> return ViewHolder(HomeHeaderView(parent!!.context))

            TYPE_SIMPLE -> {
                val videoItemView = HomeVideoItem(parent!!.context)
                return ViewHolder(videoItemView)
            }
            TYPE_HEADER_TEXT -> {
                val headerText = HomeHeaderTextView(parent!!.context)
                headerText.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                        ScreenUtil.dip2px(56f, parent!!.context))
                headerText.setBackgroundColor(Color.parseColor("#f7dba3"))
                return ViewHolder(headerText)
            }
            else -> return ViewHolder(null)
        }
    }

    override fun getItemCount(): Int {
        if (itemList.size > headViewDataSize) {
            return itemList.size - headViewDataSize + 1
        } else if (itemList.size == 0) {
            return 0
        } else {
            return 1
        }
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemViewType = getItemViewType(position)
        when (itemViewType) {
            TYPE_HEADERVIEW -> {
                (holder?.itemView as HomeHeaderView).setData(itemList.take(headViewDataSize).toCollection(ArrayList()))
            }
            TYPE_SIMPLE -> (holder?.itemView as HomeVideoItem).let {
                it.setOnClickListener { view -> view.context.startActivityWithData<VideoContentActivity>(itemList[position + headViewDataSize - 1]) }
                it.setData(itemList[position + headViewDataSize - 1], "feed")
            }
            TYPE_HEADER_TEXT -> {
                (holder?.itemView as HomeHeaderTextView).setHeaderText(itemList[position + headViewDataSize - 1].data?.text)
            }
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}