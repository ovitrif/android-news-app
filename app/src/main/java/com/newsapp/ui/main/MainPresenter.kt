package com.newsapp.ui.main

import com.newsapp.core.Threads
import com.newsapp.extensions.subscribeEmpty
import com.newsapp.ui.BasePresenter
import com.newsapp.ui.main.article.ArticleNavigatorFactory
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.main.domain.ArticleRepo
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: IMain.View,
        private val articleRepo: ArticleRepo,
        private val threads: Threads,
        private val articleNavigatorFactory: ArticleNavigatorFactory) : BasePresenter(), IMain.Presenter {

    override fun onShow() {
        loadArticles()
    }

    override fun loadArticles() {
        val getUserByNameJob = articleRepo.get()
                .subscribeOn(threads.io())
                .observeOn(threads.ui())
                .doOnSuccess {
                    when {
                        it.isNotEmpty() -> view.addArticles(it)
                        view.isListEmpty() -> view.showEmptyListPlaceholder()
                    }
                }
                .doOnError { throw it }
                .doFinally { view.hideProgressView() }
                .subscribeEmpty()
        jobsBag.add(getUserByNameJob)
    }

    override fun onArticleClick(item: Article) = articleNavigatorFactory.createForArticle(item).navigate()
}
