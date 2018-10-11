package com.newsapp.ui.main

import com.newsapp.core.Threads
import com.newsapp.domain.entities.Article
import com.newsapp.extensions.subscribeEmpty
import com.newsapp.ui.BasePresenter
import com.newsapp.ui.main.acts.GetArticlesAct
import com.newsapp.ui.main.detail.DetailNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val getArticlesAct: GetArticlesAct,
        private val threads: Threads,
        private val detailNavigator: DetailNavigator) : BasePresenter(), IMain.Presenter {

    override fun onShow() {
        val getUserByNameJob = getArticlesAct.execute()
                .subscribeOn(threads.io())
                .observeOn(threads.ui())
                .doOnSuccess {
                    view.addArticles(it)
                }
                .subscribeEmpty()
        jobsBag.add(getUserByNameJob)
    }

    override fun onArticleClick(item: Article) = detailNavigator.navigate()
}
