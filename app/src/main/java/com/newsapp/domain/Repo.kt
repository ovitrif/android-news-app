package com.newsapp.domain

interface Repo<T> {

    fun get(): T
}
