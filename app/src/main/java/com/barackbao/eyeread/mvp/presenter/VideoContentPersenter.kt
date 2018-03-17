package com.barackbao.eyeread.mvp.presenter

import android.app.Activity
import android.util.Log
import com.barackbao.eyeread.mvp.contract.VideoContentContract
import com.barackbao.eyeread.mvp.model.DetailModel
import com.barackbao.eyeread.mvp.model.bean.Issue
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.utils.getNetworkType
import io.reactivex.disposables.Disposable

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentPersenter(view: VideoContentContract.VView) : VideoContentContract.VPersenter {


    //持有model
    val videoContentModel: DetailModel by lazy { DetailModel() }
    //持有view
    val videoContentView: VideoContentContract.VView
    //更多视频评论
    var moreCommentUrl: String? = null

    init {
        videoContentView = view
    }


    override fun initPlayer(itemData: Item): Disposable? {
        val netWorkType = (videoContentView as Activity).getNetworkType()
        val playerInfo = itemData.data?.playInfo
        playerInfo?.let {
            //如果是wifi，直接播放
            if (netWorkType == 1) {
                for (playinfo in playerInfo) {
                    if (playinfo.type == "high") {
                        val videoUrl = playinfo.url
                        videoContentView.setVideo(videoUrl)
                        break
                    }
                }
            } else {
                //提示流量消耗
                for (playinfo in playerInfo) {
                    if (playinfo.type == "normal") {
                        val videoUrl = playinfo.url
                        videoContentView.setVideo(videoUrl)
                        break
                    }
                }
            }
        }
        videoContentView.setVideoInfo(itemData)
        Log.i("VideoInfo", itemData.data?.title)
        return getVideoComment(itemData?.data?.id!!)
    }


    override fun getVideoComment(videoId: Long): Disposable? {
        return videoContentModel.loadCommenList(videoId)
                .subscribe({ t: Issue ->
                    moreCommentUrl = t.nextPageUrl
                    videoContentView.setVideoComment(t)
                })
    }

    override fun getMoreVideoComment(): Disposable? {
        moreCommentUrl?.let {
            if (it !== "") {
                return videoContentModel.loadMoreCommentList(it)
                        .subscribe({ t: Issue ->
                            moreCommentUrl = t.nextPageUrl
                            videoContentView.setMoreComment(t)
                        })
            }
        }
        videoContentView.setMoreComment(null)
        return null
    }
}