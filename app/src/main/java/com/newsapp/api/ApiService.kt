package com.newsapp.api

import com.newsapp.ui.main.domain.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("feed/articles?fields=video,text,tags,image,html")
    fun getArticles(
            @Query("count") count: Int): Single<ArticlesResponse>
}
