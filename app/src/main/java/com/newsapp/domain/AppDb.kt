package com.newsapp.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.main.domain.ArticleDao

@Database(entities = [Article::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}
