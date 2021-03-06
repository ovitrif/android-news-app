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

    override fun onRefresh() {
        loadArticles()
    }

    override fun loadArticles() {
        val asyncJob = articleRepo.get()
                .subscribeOn(threads.io())
                .observeOn(threads.ui())
                .doOnSuccess {
                    when {
                        it.isNotEmpty() -> view.fillList(it)
                        view.isListEmpty() -> view.showEmptyListPlaceholder()
                    }
                }
                .doFinally { view.hideProgressView() }
                .doOnError { throw it }
                .subscribeEmpty()
        disposeBag.add(asyncJob)
    }

    override fun onArticleClick(item: Article) = articleNavigatorFactory.createForArticle(item).navigate()
}
