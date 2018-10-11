package com.newsapp.ui.main.detail

import com.newsapp.core.Threads
import com.newsapp.ui.BasePresenter
import com.newsapp.ui.main.MainNavigator
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter @Inject constructor(
        private val view: IDetail.View,
        private val threads: Threads,
        private val mainNavigator: MainNavigator) : BasePresenter(), IDetail.Presenter {

    override fun onShow() {
    }

    override fun onBackPressed() = mainNavigator.navigate()
}
