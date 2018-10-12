package com.newsapp.ui.main.domain

import com.newsapp.domain.AppDb
import com.newsapp.domain.Repo
import io.reactivex.Single
import javax.inject.Inject

class ArticleRepo @Inject constructor(
        appDb: AppDb,
        private val getArticlesAct: GetArticlesAct) : Repo<Single<List<Article>>> {

    private val dao = appDb.articleDao()

    override fun get(): Single<List<Article>> {
        val cached = dao.getAllArticles()
        val remote = getArticlesAct.execute().doOnSuccess { dao.insertAll(*it.toTypedArray()) }
        return remote.onErrorResumeNext { cached }
    }
}
