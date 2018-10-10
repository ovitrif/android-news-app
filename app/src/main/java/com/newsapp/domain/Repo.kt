package com.newsapp.domain

/**
 * Base repository interface.
 */
interface Repo<T> {

    val isSet: Boolean

    fun get(): T

    fun set(request: T)

    fun clear()
}
