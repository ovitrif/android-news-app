package com.newsapp.ui.main

import com.newsapp.ui.main.detail.DetailNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val detailNavigator: DetailNavigator) : IMain.Presenter {

    override fun onShow() {
    }

    override fun onDetailNavBtnClick() = detailNavigator.navigate()

    override fun onHide() {
    }
}
