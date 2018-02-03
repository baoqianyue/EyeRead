package com.barackbao.eyeread.mvp.model


import com.barackbao.eyeread.mvp.model.bean.HomeBean
import com.barackbao.eyeread.network.Net
import com.barackbao.eyeread.utils.io_main
import io.reactivex.Observable

/**
 * Created by BarackBao on 2018/1/27.
 */
class HomeModel {

    fun loadFirstData(): Observable<HomeBean> {
        //直接将请求操作放在了io线程
        return Net.service.getFirstHomeData(System.currentTimeMillis()).io_main()
    }

    fun loadMoreData(url: String): Observable<HomeBean> {
        //直接将请求操作放在了io线程，这里的参数为日期字符串
        return Net.service.getMoreHomeData(url).io_main()
    }
}