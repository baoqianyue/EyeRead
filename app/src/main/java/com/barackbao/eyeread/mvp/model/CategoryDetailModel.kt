package com.barackbao.eyeread.mvp.model

import com.barackbao.eyeread.mvp.model.bean.Issue
import com.barackbao.eyeread.network.Net
import com.barackbao.eyeread.utils.io_main
import io.reactivex.Observable

/**
 * Created by BarackBao on 2018/1/27.
 */
class CategoryDetailModel {
    fun loadData(id:Long):Observable<Issue>{
        return Net.service.getCategoryItemList(id).io_main()
    }

    fun loadMoreData(url:String):Observable<Issue>{
        return Net.service.getIssue(url).io_main()
    }
}