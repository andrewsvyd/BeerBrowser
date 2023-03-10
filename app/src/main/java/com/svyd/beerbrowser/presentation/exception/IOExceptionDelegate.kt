package com.svyd.beerbrowser.presentation.exception

import java.io.IOException

class IOExceptionDelegate(delegate: AbstractExceptionDelegate<*>) : AbstractExceptionDelegate<IOException>() {

    init {
        this.delegate = delegate
    }

    override fun handleException(exception: IOException) {
        view?.hideProgress()
        view?.showNoInternetConnectionError()
    }
}
