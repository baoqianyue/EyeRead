package com.barackbao.eyeread.mvp.model.bean

/**
 * Created by BarackBao on 2018/1/27.
 */
data class HomeBean(var issueList: ArrayList<Issue>, val nextPageUrl: String, val nextPublishTime: Long,
                    val newestIssueType: String, val dialog: Any)