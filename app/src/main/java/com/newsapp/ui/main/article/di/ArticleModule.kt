package com.newsapp.ui.main.article.di

import android.app.Activity
import com.newsapp.domain.entities.Article
import com.newsapp.ui.main.article.ArticleNavigator
import com.newsapp.ui.main.article.IArticle
import dagger.Module
import dagger.Provides
import java.lang.RuntimeException

@Module
class ArticleModule(
        private val activity: Activity,
        private val view: IArticle.View) {

    @Provides
    fun provideView() = view

    @Provides
    fun provideArticle() = activity.intent.extras?.getParcelable<Article>(ArticleNavigator.EXTRA_KEY) ?: throw RuntimeException()
}
