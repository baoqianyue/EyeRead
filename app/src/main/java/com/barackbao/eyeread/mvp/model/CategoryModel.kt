package com.barackbao.eyeread.mvp.model

import com.barackbao.eyeread.mvp.model.bean.Category
import com.barackbao.eyeread.network.Net
import com.barackbao.eyeread.utils.io_main
import io.reactivex.Observable

/**
 * Created by BarackBao on 2018/1/27.
 */
class CategoryModel {

    fun loadData(): Observable<ArrayList<Category>> {
        return Net.service.getCategory().io_main()
    }
}