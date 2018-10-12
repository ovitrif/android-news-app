package com.newsapp.ui.main.di

import com.newsapp.ui.main.IMain
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val view: IMain.View) {

    @Provides
    fun provideView() = view
}
