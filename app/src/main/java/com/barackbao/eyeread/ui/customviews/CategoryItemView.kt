package com.barackbao.eyeread.ui.customviews

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.barackbao.eyeread.R
import com.barackbao.eyeread.mvp.model.bean.Category
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.layout_category_item.view.*
import java.util.function.Consumer

/**
 * Created by BarackBao on 2018/3/6.
 */
class CategoryItemView : FrameLayout {
    private lateinit var bitmap: Bitmap

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_category_item, this)
    }


    /**
     * 加载分类名称和分类图片
     */
    fun setData(category: Category) {
        category_name_tv.text = category.name
        Glide.with(context).load(category.bgPicture).centerCrop().into(category_img)
        /*val observable = Observable.create(ObservableOnSubscribe<Bitmap> { e ->
            bitmap = Glide.
                    with(context).
                    load(category.bgPicture).
                    asBitmap().
                    into(-1, -1).
                    get()
            e.onNext(bitmap)
        })
        val consumer = Consumer<Bitmap> { p0 -> category_img.bitmap = p0 }

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()*/
    }
}