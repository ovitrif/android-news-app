package com.newsapp.ui.main.domain

import com.newsapp.api.ApiService
import io.reactivex.Single
import javax.inject.Inject

class GetArticlesAct @Inject constructor(
        private val apiService: ApiService) {

    private val fields = arrayOf("video", "text", "tags", "image", "html").joinToString(",")

    fun execute(count: Int = 25): Single<List<Article>> {
        return apiService.getArticles(count, fields).map { result ->
            result.response.items
                    .asSequence()
                    .sortedBy { it.created.timestamp }
                    .map {
                        Article(
                                it.id,
                                it.title,
                                it.created.timestamp,
                                it.created.formatted,
                                it.image.medium,
                                it.image.large,
                                it.text_html,
                                it.teaser_html)
                    }
                    .toList()
        }
    }
}
