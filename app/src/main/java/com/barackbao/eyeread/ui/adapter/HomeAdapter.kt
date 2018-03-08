package com.barackbao.eyeread.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.customviews.HomeHeaderView

/**
 * Created by BarackBao on 2018/3/8.
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val TYPE_HEADERVIEW = 1
    private val TYPE_SIMPLE = 2


    var itemList: ArrayList<Item> = ArrayList()

    fun addData(itemList: ArrayList<Item>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HEADERVIEW
        } else {
            return TYPE_HEADERVIEW
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        when (viewType) {
            TYPE_HEADERVIEW -> return ViewHolder(HomeHeaderView(parent!!.context))
            else -> return ViewHolder(null)
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemViewType = getItemViewType(position)
        when(itemViewType) {
            TYPE_SIMPLE -> {
                (holder?.itemView as HomeHeaderView).setData(itemList)
            }
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}