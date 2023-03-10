package com.svyd.beerbrowser.presentation.exception

class UnknownExceptionDelegate : AbstractExceptionDelegate<Throwable>() {

    override fun handleException(exception: Throwable) {
        view?.hideProgress()
        view?.showMessage(exception.message ?: "")
    }
}
