package com.svyd.beerbrowser.data.repository.beers

import com.svyd.beerbrowser.data.repository.beers.model.Beer
import io.reactivex.Observable
import retrofit2.http.GET

interface BeersService {

    @GET("beers")
    fun getBeers() : Observable<List<Beer>>
}