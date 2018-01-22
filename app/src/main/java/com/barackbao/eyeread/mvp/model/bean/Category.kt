package com.barackbao.eyeread.mvp.model.bean

import java.io.Serializable

/**
 * Created by BarackBao on 2018/1/22.
 */

data class Category(val id: Long, val name: String, val description: String, val bgImg: String,
                    val bgColor: String, val headerImg: String) : Serializable