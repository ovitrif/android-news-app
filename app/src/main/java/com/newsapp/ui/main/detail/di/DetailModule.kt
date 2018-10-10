package com.newsapp.ui.main.detail.di

import android.app.Activity
import com.newsapp.ui.main.detail.IDetail
import dagger.Module
import dagger.Provides

@Module
class DetailModule(
        private val activity: Activity,
        private val view: IDetail.View) {

    @Provides
    fun provideView() = view
}
