package com.newsapp.di

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.newsapp.api.ApiService
import com.newsapp.core.Threads
import dagger.Component
import javax.inject.Singleton

/**
 * Main application component for Dagger2.
 * Declares the globally available application singletons in the dependency injection graph.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: Application)
    fun inject(activity: Activity)
    fun inject(broadcastReceiver: BroadcastReceiver)
    fun inject(service: Service)

    fun gson(): Gson
    fun context(): Context
    fun apiService(): ApiService
    fun sharedPreferences(): SharedPreferences
    fun threads(): Threads
}