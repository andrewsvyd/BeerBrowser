package com.svyd.beerbrowser.data.repository.beers

import com.svyd.beerbrowser.data.repository.beers.model.Beer
import com.svyd.beerbrowser.data.repository.beers.model.BeersRequest
import io.reactivex.Observable

class ConcreteBeersRepository(private val service: BeersService) : BeersRepository {

    override fun getBeers(request: BeersRequest): Observable<List<Beer>> {
        return service.getBeers()
    }
}