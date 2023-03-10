package com.svyd.beerbrowser.presentation.base

import com.svyd.beerbrowser.presentation.exception.AbstractExceptionDelegate


/**
 * Base interface for all presenters.
 */
abstract class BasePresenter<V : ViewPresenterContract.View>(val errorHandler: AbstractExceptionDelegate<*>)
    : ViewPresenterContract.Presenter<V> {

    var view: V? = null

    override fun onStart() {}

    override fun initialize(view: V) {
        this.view = view
        errorHandler.view = view
    }

    companion object {
        const val KEY_INSTANCE_STATE = "instance_state"
    }
}