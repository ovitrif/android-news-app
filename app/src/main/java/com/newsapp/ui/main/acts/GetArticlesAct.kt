package com.newsapp.ui.main.acts

import com.newsapp.api.ApiService
import com.newsapp.domain.entities.Article
import io.reactivex.Single
import javax.inject.Inject

class GetArticlesAct @Inject constructor(
        private val apiService: ApiService) {

    private val fields = arrayOf("video", "text", "tags", "image", "html").joinToString(",")

    fun execute(count: Int = 25): Single<List<Article>> = apiService.getArticles(count, fields).map { it.response.items }
}
