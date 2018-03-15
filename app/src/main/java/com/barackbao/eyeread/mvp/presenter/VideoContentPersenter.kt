package com.barackbao.eyeread.mvp.presenter

import com.barackbao.eyeread.mvp.contract.VideoContentContract
import com.barackbao.eyeread.mvp.model.DetailModel
import com.barackbao.eyeread.mvp.model.bean.Item
import io.reactivex.disposables.Disposable

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentPersenter(view: VideoContentContract.VView) : VideoContentContract.VPersenter {

    //持有model
    val videoContentModel: DetailModel by lazy { DetailModel() }
    //持有view
    val videoContentView: VideoContentContract.VView

    init {
        videoContentView = view
    }


    override fun getVideoInfo(itemInfo: Item): Disposable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVideoComment(videoId: Long): Disposable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMoreVideoComment(): Disposable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}