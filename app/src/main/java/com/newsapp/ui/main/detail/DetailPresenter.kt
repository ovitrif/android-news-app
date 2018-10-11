package com.newsapp.ui.main.detail

import com.newsapp.core.Threads
import com.newsapp.ui.BasePresenter
import javax.inject.Inject

class DetailPresenter @Inject constructor(
        private val view: IDetail.View,
        private val threads: Threads) : BasePresenter(), IDetail.Presenter {

    override fun onShow() {
    }
}
