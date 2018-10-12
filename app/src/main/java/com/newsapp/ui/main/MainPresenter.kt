package com.newsapp.ui.main

import com.newsapp.core.Threads
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.main.domain.ArticleRepo
import com.newsapp.extensions.subscribeEmpty
import com.newsapp.ui.BasePresenter
import com.newsapp.ui.main.article.ArticleNavigatorFactory
import com.newsapp.ui.main.domain.GetArticlesAct
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val getArticlesAct: GetArticlesAct,
        private val threads: Threads,
        private val articleNavigatorFactory: ArticleNavigatorFactory) : BasePresenter(), IMain.Presenter {

    override fun onShow() {
        val getUserByNameJob = getArticlesAct.execute()
                .subscribeOn(threads.io())
                .observeOn(threads.ui())
                .doOnSuccess {
                    if (it.isNotEmpty()) view.addArticles(it)
                }
                .doOnError { throw it }
                .subscribeEmpty()
        jobsBag.add(getUserByNameJob)
    }

    override fun onArticleClick(item: Article) = articleNavigatorFactory.createForArticle(item).navigate()
}
