package com.newsapp.ui.main.domain

data class ArticlesResponse(
        val response: Response) {

    data class Response(
            val items: List<ArticleResponse>)

    data class ArticleResponse(
            val id: Int = 0,
            val title: String = "",
            val created: TimeStamp = TimeStamp(),
            val image: Image = Image(),
            val text_html: String = "",
            val teaser_html: String = "") {

        data class TimeStamp(
                val timestamp: Int = 0,
                val formatted: String = "")

        data class Image(
                val medium: String = "",
                val large: String = "")
    }

}
