package com.newsapp.ui.main

import com.newsapp.domain.entities.Article
import com.newsapp.ui.Presentable
import com.newsapp.ui.main.view.ArticleListAdapter

interface IMain {

    interface View {
        fun addArticles(items: List<Article>)
    }

    interface Presenter : Presentable, ArticleListAdapter.Listener
}
