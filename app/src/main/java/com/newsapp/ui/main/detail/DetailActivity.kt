package com.newsapp.ui.main.detail

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import com.newsapp.App
import com.newsapp.R
import com.newsapp.extensions.showKeyboard
import com.newsapp.ui.BaseActivity
import com.newsapp.ui.main.detail.di.DaggerDetailComponent
import com.newsapp.ui.main.detail.di.DetailModule
import com.newsapp.ui.navigator.NavigatorModule
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.view_app_bar.*

class DetailActivity : BaseActivity(), IDetail.View {

    private lateinit var presenter: IDetail.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ButterKnife.bind(this)

        val component = DaggerDetailComponent.builder()
                .appComponent(App.getAppComponent(this))
                .detailModule(DetailModule(this, this))
                .navigatorModule(NavigatorModule(this))
                .build()
        presenter = component.presenter()
        initView()
    }

    override fun onResume() {
        super.onResume()
        presenter.onShow()
    }

    override fun onStop() {
        super.onStop()
        presenter.onHide()
    }

    override fun onBackPressed() = presenter.onBackPressed()

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("")
    }
}
