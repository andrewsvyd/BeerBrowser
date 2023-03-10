package com.svyd.beerbrowser.presentation.feature.beers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.svyd.beerbrowser.R
import com.svyd.beerbrowser.data.repository.beers.model.Beer
import com.svyd.beerbrowser.presentation.application.BeersApplication
import com.svyd.beerbrowser.presentation.base.BaseActivity
import com.svyd.beerbrowser.presentation.base.ViewPresenterContract

class BeersActivity : BaseActivity(), BeersContract.View {

    private lateinit var presenter: BeersContract.Presenter
    private lateinit var adapter: BeersAdapter

    override val contentView: Int
        get() = R.layout.activity_beers

    override fun getPresenter(): ViewPresenterContract.Presenter<BeersContract.View> = presenter

    override fun initializeUi() {
        val recycler = findViewById<RecyclerView>(R.id.beers_list)
        adapter = BeersAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun initializePresenter() {
        presenter = BeersPresenterProvider(BeersApplication.instance).providePresenter()
        presenter.initialize(this)
        presenter.loadBeers()
    }

    override fun showBeers(beers: List<Beer>) {
        adapter.updateBeers(beers)
    }
}