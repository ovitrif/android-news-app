package com.newsapp.ui.main.di

import com.newsapp.di.ActivityScope
import com.newsapp.di.AppComponent
import com.newsapp.domain.RepoModule
import com.newsapp.ui.main.MainPresenter
import com.newsapp.ui.main.view.ArticleListAdapter
import com.newsapp.ui.navigator.NavigatorModule
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [MainModule::class, RepoModule::class, NavigatorModule::class])
interface MainComponent {

    fun presenter(): MainPresenter
    fun adapter(): ArticleListAdapter
}
