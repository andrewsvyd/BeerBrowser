package com.svyd.beerbrowser.presentation.feature.beers

import com.svyd.beerbrowser.data.repository.beers.BeersRepository
import com.svyd.beerbrowser.data.repository.beers.BeersService
import com.svyd.beerbrowser.data.repository.beers.ConcreteBeersRepository
import com.svyd.beerbrowser.domain.interactor.beer.BeersInteractor
import com.svyd.beerbrowser.presentation.base.di.PresenterProvider
import com.svyd.beerbrowser.presentation.base.di.ScopedDependency
import retrofit2.Retrofit

class BeersPresenterProvider(private val retrofitProvider: ScopedDependency<Retrofit>) : PresenterProvider() {

    fun providePresenter() : BeersContract.Presenter  {
        return BeersPresenter(provideInteractor(), provideExceptionDelegate())
    }

    private fun provideInteractor(): BeersInteractor {
        return BeersInteractor(provideRepository())
    }

    private fun provideRepository(): BeersRepository {
        return ConcreteBeersRepository(provideService())
    }

    private fun provideService(): BeersService {
        return retrofitProvider.provideDependency().create(BeersService::class.java)
    }
}