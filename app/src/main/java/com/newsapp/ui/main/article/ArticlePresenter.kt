package com.newsapp.ui.main.article

import com.newsapp.core.Threads
import com.newsapp.ui.BasePresenter
import javax.inject.Inject

class ArticlePresenter @Inject constructor(
        private val view: IArticle.View,
        private val threads: Threads) : BasePresenter(), IArticle.Presenter {

    override fun onShow() {
    }
}
