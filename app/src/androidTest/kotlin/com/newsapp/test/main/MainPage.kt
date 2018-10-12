package com.newsapp.test.main

import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AllOf.allOf

class MainPage {

    fun verifyTitleTextIsCorrect() {
        val expectedText = "News App"
        val matcher = allOf(isAssignableFrom(TextView::class.java), withParent(isAssignableFrom(Toolbar::class.java)))
        onView(matcher).check(matches(withText(expectedText)))
    }
}
