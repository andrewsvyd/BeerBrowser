package com.svyd.beerbrowser.presentation.base

import rx.Observer

abstract class BaseObserver<T>(private val presenter: BasePresenter<out ViewPresenterContract.View>) :
    Observer<T> {

    override fun onError(e: Throwable) {
        presenter.errorHandler.onError(e)
    }

    override fun onNext(t: T) {

    }

    override fun onCompleted() {

    }
}
