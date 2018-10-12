package com.newsapp.api

import com.newsapp.ui.main.domain.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("feed/articles")
    fun getArticles(
            @Query("count") count: Int,
            @Query("fields") fields: String): Single<ArticlesResponse>
}
