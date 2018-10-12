package com.newsapp.extensions

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Subscribes to Single with empty consumers.
 */
fun <T : Any> Single<T>.subscribeEmpty(): Disposable = subscribe({}, {})

/**
 * Subscribes to Completable with empty consumers.
 */
fun <T : Any> Completable.subscribeEmpty(): Disposable = subscribe({}, {})

/**
 * Subscribes to Observable with empty consumers.
 */
fun <T : Any> Observable<T>.subscribeEmpty(): Disposable = subscribe({}, {})

/**
 * Subscribes to Flowable with empty consumers.
 */
fun <T : Any> Flowable<T>.subscribeEmpty(): Disposable = subscribe({}, {})
