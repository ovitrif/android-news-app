package com.newsapp.domain

import com.newsapp.ui.main.domain.ArticleDao
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideArticleDao(appDb: AppDb): ArticleDao = appDb.articleDao()
}
