package com.newsapp.api

import com.google.gson.Gson
import com.newsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiceBuilder(
        private val apiUri: String,
        private val gson: Gson) {

    private val timeOut = 30L

    fun build(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        httpClient.readTimeout(timeOut, TimeUnit.SECONDS)
        httpClient.writeTimeout(timeOut, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return Retrofit.Builder().baseUrl(apiUri)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .validateEagerly(true)
                .client(httpClient.build())
                .build()
    }
}
