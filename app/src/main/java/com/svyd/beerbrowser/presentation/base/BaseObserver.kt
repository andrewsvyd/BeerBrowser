package com.svyd.beerbrowser.presentation.base

import io.reactivex.observers.DisposableObserver
import rx.Observer

abstract class BaseObserver<T : Any>(private val presenter: BasePresenter<out ViewPresenterContract.View>) :
    DisposableObserver<T>() {

    override fun onError(e: Throwable) {
        presenter.errorHandler.onError(e)
    }

    override fun onNext(t: T) {

    }

    override fun onComplete() {

    }
}
