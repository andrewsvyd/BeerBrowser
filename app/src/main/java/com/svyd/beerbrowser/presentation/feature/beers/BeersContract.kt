package com.svyd.beerbrowser.presentation.feature.beers

import com.svyd.beerbrowser.data.repository.beers.model.Beer
import com.svyd.beerbrowser.presentation.base.ViewPresenterContract

interface BeersContract {
    interface View : ViewPresenterContract.View  {
        fun showBeers(beers: List<Beer>)
    }
    interface Presenter : ViewPresenterContract.Presenter<BeersContract.View> {
        fun loadBeers()
    }
}