package com.svyd.beerbrowser.presentation.base.di

/**
 * Used to create dependencies within a scope, e.g. Application, Activity, Fragment
 * without passing application or concrete fragment with exposed api
 * If the class that implements this interface needs to  provide multiple dependencies -
 * then the T can be a data class, with fields of needed dependencies, serving as a bundle for all
 * dependencies in a given scope
 */
interface ScopedDependency<out T> {
    fun provideDependency() : T
}