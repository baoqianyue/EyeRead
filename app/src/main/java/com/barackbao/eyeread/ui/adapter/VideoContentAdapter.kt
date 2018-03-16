package com.barackbao.eyeread.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.customviews.VideoContentCommentView
import com.barackbao.eyeread.ui.customviews.VideoContentInfoView

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentAdapter : RecyclerView.Adapter<VideoContentAdapter.ViewHolder>() {
    private val TYPE_VIDEO_INFO = 0
    private val TYPE_VIDEO_COMMENT = 1

    val data: ArrayList<Item> by lazy { ArrayList<Item>() }


    fun addData(item: Item) {
        data.clear()
        notifyDataSetChanged()
        data.add(item)
        notifyItemInserted(0)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_VIDEO_INFO
        } else {
            TYPE_VIDEO_COMMENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View? = null
        when (viewType) {
            TYPE_VIDEO_INFO -> {
                itemView = VideoContentInfoView(parent?.context)
            }

            TYPE_VIDEO_COMMENT -> {
                itemView = VideoContentCommentView(parent?.context)
            }
        }
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size + 1

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemView = holder?.itemView
        when (getItemViewType(position)) {
            TYPE_VIDEO_INFO -> {
                (itemView as VideoContentInfoView).let {
                    it.setData(data[position])
                }
            }
            TYPE_VIDEO_COMMENT -> {
                (itemView as VideoContentCommentView).let {
                }
            }
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}