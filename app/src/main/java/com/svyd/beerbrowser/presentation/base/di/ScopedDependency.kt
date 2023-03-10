package com.svyd.beerbrowser.presentation.base.di

interface ScopedDependency<out T> {
    fun provideDependency() : T
}