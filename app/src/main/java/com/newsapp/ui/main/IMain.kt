package com.newsapp.ui.main

import com.newsapp.ui.Presentable

interface IMain {

    interface View {
    }

    interface Presenter : Presentable {
        fun onDetailNavBtnClick()
    }
}
