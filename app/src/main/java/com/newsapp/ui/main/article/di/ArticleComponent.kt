package com.newsapp.ui.main.article.di

import com.newsapp.di.ActivityScope
import com.newsapp.di.AppComponent
import com.newsapp.ui.main.article.ArticlePresenter
import com.newsapp.ui.navigator.NavigatorModule
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [ArticleModule::class, NavigatorModule::class]
)
interface ArticleComponent {

    fun presenter(): ArticlePresenter
}
