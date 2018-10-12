package com.newsapp.test

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.newsapp.ui.main.MainActivity
import junit.framework.Assert
import org.junit.Rule
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class BaseTest : Assert() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)
}
