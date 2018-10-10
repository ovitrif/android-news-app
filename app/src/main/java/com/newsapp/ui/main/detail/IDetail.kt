package com.newsapp.ui.main.detail

import android.support.annotation.StringRes
import com.newsapp.ui.Presentable

interface IDetail {

    interface View {
        val userName: String
        var dataText: String
        fun setInputError(@StringRes errorMessage: Int)
        fun clearInputError()
    }

    interface Presenter : Presentable {
        fun onGetClick()
        fun onBackPressed()
    }
}
