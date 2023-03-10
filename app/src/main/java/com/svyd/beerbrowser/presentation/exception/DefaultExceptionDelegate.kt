package com.svyd.beerbrowser.presentation.exception

class DefaultExceptionDelegate(delegate: AbstractExceptionDelegate<*>) : AbstractExceptionDelegate<Throwable>() {

    init {
        this.delegate = delegate
    }

    override fun handleException(exception: Throwable) {
        delegate?.onError(exception)
    }
}
