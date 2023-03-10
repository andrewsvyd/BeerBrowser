package com.svyd.beerbrowser.presentation.feature.beers

import android.os.Bundle
import com.svyd.beerbrowser.data.repository.beers.model.Beer
import com.svyd.beerbrowser.data.repository.beers.model.BeersRequest
import com.svyd.beerbrowser.domain.interactor.beer.BeersInteractor
import com.svyd.beerbrowser.presentation.base.BaseObserver
import com.svyd.beerbrowser.presentation.base.BasePresenter
import com.svyd.beerbrowser.presentation.exception.AbstractExceptionDelegate

class BeersPresenter constructor(
    private val interactor: BeersInteractor,
    errorHandler: AbstractExceptionDelegate<*>
) : BasePresenter<BeersContract.View>(errorHandler), BeersContract.Presenter {

    override fun loadBeers() {
        //todo: implement proper filtering and pagination
        interactor.execute(BeersObserver(this), BeersRequest(emptyList(), 0))
    }

    override fun onStop() {
        interactor.dispose()
    }

    override fun restoreState(state: Bundle) {
        //todo: unpack beers from bundle
    }

    override fun saveState(state: Bundle) {
        //todo: save beers into bundle
    }

    inner class BeersObserver(presenter: BasePresenter<*>) :
            BaseObserver<List<Beer>>(presenter) {

        override fun onStart() {
            view?.showProgress()
        }

        override fun onNext(t: List<Beer>) {
            view?.showBeers(t)
        }

        override fun onComplete() {
            view?.hideProgress()
        }
    }
}