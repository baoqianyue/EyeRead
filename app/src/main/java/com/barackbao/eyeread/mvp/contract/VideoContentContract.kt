package com.barackbao.eyeread.mvp.contract

import com.barackbao.eyeread.mvp.base.BasePresenter
import com.barackbao.eyeread.mvp.base.BaseView
import com.barackbao.eyeread.mvp.model.bean.Item
import io.reactivex.disposables.Disposable

/**
 * Created by BarackBao on 2018/3/15.
 * 视频详情契约类
 */
interface VideoContentContract {

    interface VView : BaseView<VPersenter> {
        //设置视频播放
        fun setVideo(videoUrl: String)

        //设置视频相关信息
        fun setVideoInfo(info: Item)

        //设置视频评论
        fun setVideoComment(title: String)

        //设置背景
        fun setBackground(url: String)
    }

    interface VPersenter : BasePresenter {
        //获取视频相关信息
        fun getVideoInfo(itemInfo: Item): Disposable?

        //获取视频评论
        fun getVideoComment(videoId: Long): Disposable?

        //获取更多评论
        fun getMoreVideoComment(): Disposable?
    }

}