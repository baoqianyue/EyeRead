package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Item
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import kotlinx.android.synthetic.main.layout_video_comment_detail.view.*

/**
 * Created by BarackBao on 2018/3/15.
 */
class VideoCommentDetailView : RelativeLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.layout_video_comment_detail, this)
    }

    fun setData(item: Item) {
        //设置圆形头像
        val circleAvatar = object : BitmapImageViewTarget(this.comment_avatar_img) {
            override fun setResource(resource: Bitmap?) {
                super.setResource(resource)
                val circleBitmapDrawable = RoundedBitmapDrawableFactory.create(resources, resource)
                circleBitmapDrawable.isCircular = true
                comment_avatar_img.setImageDrawable(circleBitmapDrawable)
            }
        }
        Glide.with(context).load(item.data?.user?.avatar).asBitmap().centerCrop().into(circleAvatar)

        this.nickname_tv.text = item.data?.user?.nickname
        this.like_tv.text = "" + if (item.data?.likeCount == 0) "" else item.data?.likeCount
        if (item.data?.parentReply != null) {
            this.comment_tv.text = item.data?.parentReply?.user.nickname
        }

    }
}