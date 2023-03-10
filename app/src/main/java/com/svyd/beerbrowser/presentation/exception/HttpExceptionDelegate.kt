package com.svyd.beerbrowser.presentation.exception

import retrofit2.HttpException

class HttpExceptionDelegate(delegate: AbstractExceptionDelegate<*>) : AbstractExceptionDelegate<HttpException>() {

    companion object {
        private const val UNAUTHORIZED = 401
        private const val FORBIDDEN = 403
    }

    init {
        this.delegate = delegate
    }

    override fun handleException(exception: HttpException) {
        view?.hideProgress()
        if (exception.code() == UNAUTHORIZED || exception.code() == FORBIDDEN) {
            view?.unauthorised()
        } else {
            exception.response()?.let { view?.showMessage(it.message()) }
        }
    }
}
