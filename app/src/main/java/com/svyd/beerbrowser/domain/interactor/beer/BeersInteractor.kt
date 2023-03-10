package com.svyd.beerbrowser.domain.interactor.beer

import com.svyd.beerbrowser.data.repository.beers.BeersRepository
import com.svyd.beerbrowser.data.repository.beers.model.Beer
import com.svyd.beerbrowser.data.repository.beers.model.BeersRequest
import com.svyd.beerbrowser.domain.interactor.base.Interactor
import io.reactivex.Observable

class BeersInteractor(private val repository: BeersRepository) : Interactor<List<Beer>, BeersRequest>() {
    override fun buildObservable(params: BeersRequest): Observable<List<Beer>> {
        return repository.getBeers(params)
    }
}