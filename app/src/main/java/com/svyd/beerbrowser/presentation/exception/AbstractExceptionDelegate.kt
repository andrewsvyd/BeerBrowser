package com.svyd.beerbrowser.presentation.exception

import com.svyd.beerbrowser.presentation.base.ViewPresenterContract
import java.lang.reflect.ParameterizedType

abstract class AbstractExceptionDelegate<T : Throwable> {

    var view: ViewPresenterContract.View? = null
        set(value) {
            field = value
            delegate?.view = value
        }
    var delegate: AbstractExceptionDelegate<*>? = null
    private var genericExceptionClass: Class<T>? = null

    init {
        if (genericExceptionClass == null) {
            val pt = javaClass.genericSuperclass as ParameterizedType
            genericExceptionClass = pt.actualTypeArguments[0] as Class<T>
        }
    }

    fun onError(exception: Throwable) {
        if (isRightException(exception)) {
            handleException(exception as T)
        } else {
            delegate?.onError(exception)
        }
    }

    private fun isRightException(exception: Throwable): Boolean {
        return genericExceptionClass!!.isAssignableFrom(exception.javaClass)
    }

    protected abstract fun handleException(exception: T)
}
