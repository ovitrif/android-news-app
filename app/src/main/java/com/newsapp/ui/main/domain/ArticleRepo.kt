package com.newsapp.ui.main.domain

import com.newsapp.domain.Repo
import io.reactivex.Single
import javax.inject.Inject

class ArticleRepo @Inject constructor(
        private val articleDao: ArticleDao,
        private val getArticlesAct: GetArticlesAct) : Repo<Single<List<Article>>> {

    override fun get(): Single<List<Article>> {
        val cached = articleDao.getAllArticles()
        val remote = getArticlesAct.execute().doOnSuccess { articleDao.insertAll(*it.toTypedArray()) }
        return remote.onErrorResumeNext { cached }
    }
}
