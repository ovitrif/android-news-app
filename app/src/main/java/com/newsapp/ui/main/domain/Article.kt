package com.newsapp.ui.main.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Article(
        @PrimaryKey val id: Int = 0,
        val title: String = "",
        val createdTimestamp: Int = 0,
        val created: String = "",
        val imageMedium: String = "",
        val imageLarge: String = "",
        val textHtml: String = "",
        val textExcerpt: String = "") : Parcelable
