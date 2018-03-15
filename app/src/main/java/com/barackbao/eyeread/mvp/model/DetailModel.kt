package com.barackbao.eyeread.mvp.model

import com.barackbao.eyeread.mvp.model.bean.Issue
import com.barackbao.eyeread.network.Net
import com.barackbao.eyeread.utils.io_main
import io.reactivex.Observable
import java.util.*

/**
 * Created by BarackBao on 2018/1/27.
 */
class DetailModel {

    //评论
    fun loadCommenList(videoId: Long): Observable<Issue> {
        return Net.service.getComment(videoId).io_main()
    }
}