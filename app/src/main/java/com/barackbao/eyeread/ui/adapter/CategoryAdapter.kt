package com.barackbao.eyeread.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.ui.customviews.CategoryItemView
import com.barackbao.eyeread.ui.customviews.EndListView
import kotlinx.android.synthetic.main.layout_list_end.view.*

/**
 * Created by 22876 on 2018/3/5.
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val TYPE_SIMPLE = 1
    private val TYPE_END = 2
    var onClick: ((Category) -> Unit)? = {}


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
        when (viewType) {
            TYPE_END -> {
                itemView = EndListView(parent?.context)
                itemView.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                        RecyclerView.LayoutParams.WRAP_CONTENT)
                itemView.end_list_tv.setTextColor(Color.BLACK)
            }

            TYPE_SIMPLE -> {
                itemView = CategoryItemView(parent?.context)
            }
        }
        return CategoryAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val itemViewType = getItemViewType(position)
        when (itemViewType) {
            TYPE_SIMPLE -> {
                (holder?.itemView as CategoryItemView).setData(data[position])
                //设置点击事件
            }
        }
    }

    fun setData(data: ArrayList<Category>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)


}