package com.barackbao.eyeread.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by BarackBao on 2018/2/1.
 */
object Net {
    private val retrofit: Retrofit
    //Retrofit初始化时需要的基础url，然后使用@GET注解拼接具体的请求url
    private val base_url: String = "http://baobab.kaiyanapp.com/api/"
    private val DEFAULT_TIMEOUT = 5L
    private val okHttpClient: OkHttpClient

    init {
        val longging = Interceptor { chain ->
            val request = chain.request()
            chain.proceed(request)
        }
        okHttpClient = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(longging)
                .build()

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//将Call转换成RxJavaObservable对象
                .baseUrl(base_url)
                .build()
    }

    val service: Api by lazy { retrofit.create(Api::class.java) }

}