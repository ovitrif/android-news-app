package com.newsapp.ui.main.detail.di

import com.newsapp.di.ActivityScope
import com.newsapp.di.AppComponent
import com.newsapp.ui.main.detail.DetailPresenter
import com.newsapp.ui.navigator.NavigatorModule
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [DetailModule::class, NavigatorModule::class]
)
interface DetailComponent {

    fun presenter(): DetailPresenter
}
