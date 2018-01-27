package com.barackbao.eyeread.mvp.model.bean

/**
 * Created by BarackBao on 2018/1/27.
 */
data class Issue(val releaseTime: Long, val type: String, val date: Long, val total: Int, val publishTime: Long,
                 val itemList: ArrayList<Item>, var count: Int, val nextPageUrl: String)
