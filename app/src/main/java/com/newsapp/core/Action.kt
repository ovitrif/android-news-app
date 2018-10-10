package com.newsapp.core

/**
 * Adds an action for a type.
 */
interface Action<T> {

    fun call(t: T)
}
