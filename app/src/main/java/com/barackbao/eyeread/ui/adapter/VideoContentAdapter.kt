package com.barackbao.eyeread.ui.adapter

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.customviews.PercentTextView
import com.barackbao.eyeread.ui.customviews.VideoCommentDetailView
import com.barackbao.eyeread.ui.customviews.VideoContentInfoView

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentAdapter : RecyclerView.Adapter<VideoContentAdapter.ViewHolder>() {
    private val TYPE_VIDEO_INFO = 0
    private val TYPE_VIDEO_COMMENT = 2

    val data: ArrayList<Item> by lazy { ArrayList<Item>() }

    val commentData: ArrayList<Item> by lazy { ArrayList<Item>() }


    fun addData(item: Item) {
        data.add(item)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_VIDEO_INFO
        } else {
            TYPE_VIDEO_COMMENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View
        when (viewType) {
            TYPE_VIDEO_INFO -> {
                itemView = VideoContentInfoView(parent?.context)
            }

            TYPE_VIDEO_COMMENT -> {
                itemView = VideoCommentDetailView(parent?.context)
            }
            else -> {
                throw IllegalAccessException("数据错误")
            }
        }
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemView = holder?.itemView
        when (getItemViewType(position)) {
            TYPE_VIDEO_INFO -> {
                (itemView as VideoContentInfoView).let {
                    it.setData(data[position])
                }
            }
            TYPE_VIDEO_COMMENT -> {
                (itemView as VideoCommentDetailView).let {
                }
            }
        }
    }



    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}