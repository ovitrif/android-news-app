package com.newsapp.domain

/**
 * Base repository interface.
 */
interface Repo<T> {

    fun get(): T
}
