package com.newsapp.ui.main.article

import com.newsapp.ui.Presentable

interface IArticle {

    interface View {
        fun setTitle(text: String)
        fun setContent(text: String)
    }

    interface Presenter : Presentable {
    }
}
