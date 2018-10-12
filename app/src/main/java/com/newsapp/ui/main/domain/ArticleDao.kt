package com.newsapp.ui.main.domain

import androidx.room.*
import io.reactivex.Single

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article ORDER BY createdTimestamp")
    fun getAllArticles(): Single<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg articles: Article)

    @Delete
    fun delete(article: Article)
}
