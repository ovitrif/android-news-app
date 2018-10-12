package com.newsapp.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.newsapp.R
import com.newsapp.api.ApiService
import com.newsapp.api.ApiServiceBuilder
import com.newsapp.core.Threads
import com.newsapp.domain.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideApiService(
            gson: Gson): ApiService {
        val apiUri = context.getString(R.string.api)
        val apiServiceBuilder = ApiServiceBuilder(
                apiUri,
                gson)

        return apiServiceBuilder
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideThreads() = Threads(Handler(Looper.getMainLooper()))

    @Provides
    @Singleton
    fun provideAppDb(): AppDb = Room.databaseBuilder(context, AppDb::class.java, "store.db").build()
}
