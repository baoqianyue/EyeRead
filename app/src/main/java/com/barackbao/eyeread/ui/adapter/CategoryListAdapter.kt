package com.barackbao.eyeread.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.ui.activity.VideoContentActivity
import com.barackbao.eyeread.ui.customviews.HomeVideoItem
import com.barackbao.eyeread.utils.startActivityWithData

/**
 * Created by 22876 on 2018/3/18.
 */
class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    val data: ArrayList<Item> by lazy { ArrayList<Item>() }


    fun addData(itemList:ArrayList<Item>){
        this.data.addAll(itemList)
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder?.itemView as HomeVideoItem).let {
            it.setOnClickListener { view -> view.context.startActivityWithData<VideoContentActivity>(data[position]) }
            it.setData(data[position], "categorydetail")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(HomeVideoItem(parent!!.context))


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}