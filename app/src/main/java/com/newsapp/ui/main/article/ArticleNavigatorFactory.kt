package com.newsapp.ui.main.article

import android.app.Activity
import com.newsapp.domain.entities.Article
import com.newsapp.ui.navigator.Navigator
import javax.inject.Inject

class ArticleNavigatorFactory @Inject constructor(private val activity: Activity) {

    fun createForArticle(article: Article): Navigator = ArticleNavigator(article, activity)
}
