package com.newsapp.ui.main.article

import android.os.Bundle
import butterknife.ButterKnife
import com.newsapp.App
import com.newsapp.R
import com.newsapp.extensions.toHtml
import com.newsapp.ui.BaseActivity
import com.newsapp.ui.main.article.di.ArticleModule
import com.newsapp.ui.main.article.di.DaggerArticleComponent
import com.newsapp.ui.navigator.NavigatorModule
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.view_app_bar.*
import kotlinx.android.synthetic.main.view_app_bar_image.*

class ArticleActivity : BaseActivity(), IArticle.View {

    private lateinit var presenter: IArticle.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        ButterKnife.bind(this)

        val component = DaggerArticleComponent.builder()
                .appComponent(App.getAppComponent(this))
                .articleModule(ArticleModule(this, this))
                .navigatorModule(NavigatorModule(this))
                .build()
        presenter = component.presenter()
        initView()
        presenter.onShow()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onHide()
    }

    override fun setTitle(text: String) {
        headline.text = text
    }

    override fun setText(text: String) = with(body) { this.text = text.toHtml() }

    override fun setCoverImage(url: String) {
        if (url.isNotBlank()) {
            Picasso.get()
                    .load(url)
                    .placeholder(R.color.colorTextDark)
                    .into(imageCover)
        }
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle(0)
    }
}
