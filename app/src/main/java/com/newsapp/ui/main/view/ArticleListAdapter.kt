package com.newsapp.ui.main.view

import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.adapter.GroupieAdapter
import javax.inject.Inject

class ArticleListAdapter @Inject constructor() : GroupieAdapter() {

    fun fill(items: List<Article>) {
        clear()
        addAll(items.asSequence().map { ArticleListItem(it) }.toList())
    }

    fun isEmpty() = itemCount == 0

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
