package com.newsapp.ui.main.view

import com.newsapp.domain.entities.Article
import com.newsapp.ui.adapter.GroupieAdapter
import javax.inject.Inject

class ArticleListAdapter @Inject constructor() : GroupieAdapter() {

    fun append(items: List<Article>) = addAll(items.asSequence().map { ArticleListItem(it) }.toList())

    fun setListener(listener: Listener) {
        this.setOnItemClickListener { item, _ ->
            if (item is ArticleListItem) {
                listener.onArticleClick(item.data)
            }
        }
    }

    interface Listener {

        fun onArticleClick(item: Article)
    }
}
