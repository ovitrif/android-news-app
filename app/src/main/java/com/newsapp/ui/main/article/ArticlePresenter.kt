package com.newsapp.ui.main.article

import com.newsapp.domain.entities.Article
import com.newsapp.ui.BasePresenter
import javax.inject.Inject

class ArticlePresenter @Inject constructor(
        private val view: IArticle.View,
        private val article: Article) : BasePresenter(), IArticle.Presenter {

    override fun onShow() {
        view.setTitle(article.title)
        view.setCoverImage(article.image.large)
        view.setText(article.text_html)
    }
}
