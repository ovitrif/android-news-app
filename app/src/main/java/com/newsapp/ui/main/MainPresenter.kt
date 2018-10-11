package com.newsapp.ui.main

import com.newsapp.ui.BasePresenter
import com.newsapp.ui.main.detail.DetailNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val detailNavigator: DetailNavigator) : BasePresenter(), IMain.Presenter {

    override fun onShow() {
    }
}
