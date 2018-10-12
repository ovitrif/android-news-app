package com.newsapp.ui.main.article

import android.app.Activity
import android.content.Intent
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.navigator.Navigator
import javax.inject.Inject

class ArticleNavigator @Inject constructor(
        private val article: Article,
        private val activity: Activity) : Navigator {

    override fun navigate() {
        val intent = Intent(activity, ArticleActivity::class.java)
        intent.putExtra(EXTRA_KEY, article)

        activity.startActivity(intent)
    }

    companion object {
        const val EXTRA_KEY = "EXTRA_ARTICLE"
    }
}
