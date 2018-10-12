package com.newsapp.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.newsapp.api.ApiService
import com.newsapp.core.Threads
import com.newsapp.domain.AppDb
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: Application)

    fun gson(): Gson
    fun context(): Context
    fun apiService(): ApiService

    fun threads(): Threads
    fun appDb(): AppDb
}
