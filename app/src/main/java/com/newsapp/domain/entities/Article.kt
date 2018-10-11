package com.newsapp.domain.entities

data class Article(
        val id: Int,
        val title: String,
        val created: TimeStamp,
        val url: String,
        val airdate: TimeStamp,
        val image: Image,
        val text: String,
        val text_html: String,
        val teaser: String,
        val teaser_html: String) {

    data class TimeStamp(
            val timestamp: Int,
            val formatted: String)

    data class Image(
            val uri: String,
            val thumb: String,
            val medium: String,
            val large: String,
            val full: String)
}
