package com.newsapp.ui.main.di

import android.app.Activity
import com.newsapp.ui.main.IMain
import dagger.Module
import dagger.Provides

@Module
class MainModule(
        private val activity: Activity,
        private val view: IMain.View) {

    @Provides
    fun provideView() = view
}
