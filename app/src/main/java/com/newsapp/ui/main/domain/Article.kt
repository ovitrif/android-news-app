package com.newsapp.ui.main.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
        val title: String = "",
        val createdTimestamp: Int = 0,
        val created: String = "",
        val imageMedium: String = "",
        val imageLarge: String = "",
        val textHtml: String = "",
        val teaserHtml: String = "") : Parcelable
