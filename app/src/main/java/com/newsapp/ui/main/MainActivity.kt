package com.newsapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import com.newsapp.App
import com.newsapp.R
import com.newsapp.ui.BaseActivity
import com.newsapp.ui.main.di.DaggerMainComponent
import com.newsapp.ui.main.di.MainModule
import com.newsapp.ui.main.domain.Article
import com.newsapp.ui.main.view.ArticleListAdapter
import com.newsapp.ui.navigator.NavigatorModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_app_bar.*

class MainActivity : BaseActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter
    private lateinit var adapter: ArticleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val component = DaggerMainComponent.builder()
                .appComponent(App.getAppComponent(this))
                .mainModule(MainModule(this, this))
                .navigatorModule(NavigatorModule(this))
                .build()
        presenter = component.presenter()
        adapter = component.adapter()

        initView()
        presenter.onShow()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onHide()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    override fun addArticles(items: List<Article>) {
        articleList.visibility = View.VISIBLE
        adapter.append(items)
    }

    override fun hideProgressView() = progressBar.hide()

    override fun showEmptyListPlaceholder() {
        noItemsView.visibility = View.VISIBLE
    }

    override fun isListEmpty() = adapter.isEmpty()

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.main_title)
        adapter.setListener(presenter)
        articleList.adapter = adapter
        articleList.layoutManager = LinearLayoutManager(this)
    }
}
