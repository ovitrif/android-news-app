package com.newsapp.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import com.newsapp.App
import com.newsapp.R
import com.newsapp.ui.BaseActivity
import com.newsapp.ui.main.di.DaggerMainComponent
import com.newsapp.ui.main.di.MainModule
import com.newsapp.ui.navigator.NavigatorModule
import kotlinx.android.synthetic.main.view_app_bar.*

class MainActivity : BaseActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter

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

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.main_title)
    }
}
