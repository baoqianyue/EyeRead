package com.barackbao.eyeread.ui.activity

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.contract.VideoContentContract
import com.barackbao.eyeread.mvp.model.bean.Item
import com.barackbao.eyeread.mvp.presenter.VideoContentPersenter
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import kotlinx.android.synthetic.main.activity_videocontent.*

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoContentActivity : AppCompatActivity(), VideoContentContract.VView {
    //持有persenter
    lateinit var persenter: VideoContentPersenter
    var itemData: Item? = null
    val adapter by lazy {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videocontent)
        persenter = VideoContentPersenter(this)
        initView()
        setData()
    }

    private fun initView() {
        //设置视频全屏播放
        video_view.fullscreenButton.setOnClickListener {
            if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                //设置为横屏
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
            video_view.startWindowFullscreen(this, true, true)
        }
        video_content_rv.layoutManager = LinearLayoutManager(this)


    }

    /**
     * 设置视频全屏退出键
     * orientation|screenSize|keyboardHidden改变时调用该方法
     */
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        video_view.fullscreenButton.setOnClickListener {
            //退出全屏
            GSYVideoPlayer.backFromWindowFull(this)
            if (this.resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT) {
                //设置为竖屏
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }


    private fun setData() {
    }


    override fun setPresenter(presenter: VideoContentContract.VPersenter) {

    }

    override fun setVideo(videoUrl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVideoInfo(info: Item) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVideoComment(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBackground(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}