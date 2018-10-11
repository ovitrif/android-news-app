package com.newsapp.ui.main.article

import android.app.Activity
import android.content.Intent
import com.newsapp.domain.entities.Article
import com.newsapp.ui.navigator.Navigator
import javax.inject.Inject

class ArticleNavigator @Inject constructor(
        private val activity: Activity) : Navigator {

    override fun navigate() {
        val intent = Intent(activity, ArticleActivity::class.java)

        activity.startActivity(intent)
    }
}
