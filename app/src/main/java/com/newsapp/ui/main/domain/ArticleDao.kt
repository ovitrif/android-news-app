package com.newsapp.ui.main.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article ORDER BY createdTimestamp DESC")
    fun getAllArticles(): Single<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg articles: Article)
}
