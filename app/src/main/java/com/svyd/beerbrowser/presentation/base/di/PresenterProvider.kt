package com.svyd.beerbrowser.presentation.base.di

import com.svyd.beerbrowser.presentation.exception.*

open class PresenterProvider {
    protected fun provideExceptionDelegate(): AbstractExceptionDelegate<*> {
        val unknownExceptionDelegate = UnknownExceptionDelegate()
        val ioExceptionDelegate = IOExceptionDelegate(unknownExceptionDelegate)
        val httpExceptionDelegate = HttpExceptionDelegate(ioExceptionDelegate)

        return DefaultExceptionDelegate(httpExceptionDelegate)
    }
}