package com.newsapp.test.main

import com.newsapp.test.BaseTest
import org.junit.Before
import org.junit.Test

class MainPageTest : BaseTest() {

    private lateinit var page: MainPage

    @Before
    fun setUp() {
        page = MainPage()
    }

    @Test
    fun pageElementsAreDisabled() {
        page.verifyTitleTextIsCorrect()
    }
}
