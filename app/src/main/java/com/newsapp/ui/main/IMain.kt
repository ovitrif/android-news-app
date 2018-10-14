package com.newsapp.ui.main

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.Presentable
import com.newsapp.ui.main.view.ArticleListAdapter

interface IMain {

    interface View {
        fun fillList(items: List<Article>)
        fun hideProgressView()
        fun showEmptyListPlaceholder()
        fun isListEmpty(): Boolean
    }

    interface Presenter : Presentable, ArticleListAdapter.Listener, SwipeRefreshLayout.OnRefreshListener {
        fun loadArticles()
    }
}
