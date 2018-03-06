package com.barackbao.eyeread.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Category

/**
 * Created by 22876 on 2018/3/5.
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val TYPE_SIMPLE = 1
    private val TYPE_END = 2

    val data by lazy { ArrayList<Category>() }


    override fun getItemCount(): Int {
        if (data.size == 0)
            return 0
        else
            return data.size + 1 //最后要显示一个end结尾的提示
    }


    override fun getItemViewType(position: Int): Int {
        if (data.size == position) //如果当前滑动位置等于最后data的size说明已经到了尾部
            return TYPE_END
        else
            return TYPE_SIMPLE
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View? = null
        when(viewType){
            TYPE_END -> {

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}