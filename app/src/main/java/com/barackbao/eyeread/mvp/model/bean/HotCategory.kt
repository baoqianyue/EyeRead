package com.barackbao.eyeread.mvp.model.bean

/**
 * Created by BarackBao on 2018/1/27.
 */
data class HotCategory(val tabInfo: TabInfo) {
    data class TabInfo(val tablist: ArrayList<Tab>)//周排名、月排名、总排名
    data class Tab(val id: Long, val name: String, val apiUrl: String) //一整页的api
}