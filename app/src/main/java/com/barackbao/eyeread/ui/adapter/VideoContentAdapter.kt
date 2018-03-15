package com.barackbao.eyeread.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.customviews.VideoContentInfoView

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentAdapter : RecyclerView.Adapter<VideoContentAdapter.ViewHolder>() {
    private val TYPE_VIDEO_INFO = 0
    private val TYPE_VIDEO_COMMENT = 1

    val data: ArrayList<Item> by lazy { ArrayList<Item>() }


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
                itemView =
            }


        }
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}