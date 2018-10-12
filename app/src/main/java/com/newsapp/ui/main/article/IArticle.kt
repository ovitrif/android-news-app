package com.newsapp.ui.main.article

import com.newsapp.ui.Presentable

interface IArticle {

    interface View {
        fun setTitle(text: String)
        fun setText(text: String)
        fun setCoverImage(url: String)
    }

    interface Presenter : Presentable
}
