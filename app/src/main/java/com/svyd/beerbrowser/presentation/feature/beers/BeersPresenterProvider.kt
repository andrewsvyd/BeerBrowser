package com.svyd.beerbrowser.presentation.feature.beers

import com.svyd.beerbrowser.domain.interactor.beer.BeersInteractor
import com.svyd.beerbrowser.presentation.base.di.PresenterProvider

class BeersPresenterProvider : PresenterProvider() {

    fun provideBeersPresenter() : BeersContract.Presenter  {
        return BeersPresenter(provideBeersInteractor(), provideExceptionDelegate())
    }

    private fun provideBeersInteractor(): BeersInteractor {
        TODO("Not yet implemented")
    }
}