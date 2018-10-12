package com.newsapp.extensions

import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Subscribes to Single with empty consumers.
 */
fun <T : Any> Single<T>.subscribeEmpty(): Disposable = subscribe({}, {})
