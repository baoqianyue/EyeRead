package com.barackbao.eyeread.network

import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.mvp.model.bean.HomeBean
import com.barackbao.eyeread.mvp.model.bean.HotCategory
import com.barackbao.eyeread.mvp.model.bean.Issue
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


/**
 * Created by BarackBao on 2018/2/1.
 */
interface Api {
    /**
     * 每日精选(首页banner加上num页数据，num是几就是几页数据)
     * 不输入date就只是banner，输入日期就是当日的数据
     */
    @GET("v2/feed?&num=1")//返回为RxJava对象被观察者对象，泛型参数指定为首页Model
    fun getFirstHomeData(@Query("date") date: Long): Observable<HomeBean>


    /**
     * 首页更多数据，使用nextpageurl
     * 如果在@GET中没有设置url，就可以使用@Url注解以参数的形式在调用处赋值url
     */
    @GET
    fun getMoreHomeData(@Url url: String): Observable<HomeBean>


    /**
     * 获取Issue列表，issue中包含了itemlist和nextpageurl
     */
    @GET
    fun getIssue(@Url url: String): Observable<Issue>

    /**
     * 获取热门排行数据
     */
    @GET
    fun getHotCategory(@Url url: String): Observable<HotCategory>


    /**
     * 获取分类
     */
    @GET("v4/categories")
    fun getCategory(): Observable<Category>


    /**
     * 获取分类下的所有视频
     */

    @GET("v4/categories/videoList")
    fun getCategoryItemList(@Query("id") id: Long): Observable<Issue>


    /**
     * 获取回复
     */

}