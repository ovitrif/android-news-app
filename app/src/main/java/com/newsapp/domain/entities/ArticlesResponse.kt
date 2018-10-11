package com.newsapp.domain.entities

data class ArticlesResponse(
        val response: Response) {

    data class Response(
            val items: List<Article>)
}
