package com.newsapp.di

import javax.inject.Scope

/**
 * Activity retention scope for Dagger2.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
